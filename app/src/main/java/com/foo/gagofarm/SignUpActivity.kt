package com.foo.gagofarm

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.util.Log
import android.view.MenuItem
import android.view.View
import android.widget.Button
import android.widget.Toast
import androidx.core.content.res.ResourcesCompat
import androidx.core.view.isVisible
import androidx.databinding.DataBindingUtil
import com.foo.gagofarm.databinding.ActivitySignUpBinding
import com.google.firebase.FirebaseException
import com.google.firebase.FirebaseTooManyRequestsException
import com.google.firebase.auth.*
import com.google.firebase.auth.ktx.auth
import com.google.firebase.ktx.Firebase

class SignUpActivity : AppCompatActivity() {
    private val TAG = "SignUpActivity"
    private lateinit var binding: ActivitySignUpBinding
    private val mContext = this

    private lateinit var auth: FirebaseAuth
    private var storedVerificationId = ""
    private var resendToken: PhoneAuthProvider.ForceResendingToken? = null
    private val callbacks by lazy {
        object : PhoneAuthProvider.OnVerificationStateChangedCallbacks() {
            override fun onCodeSent(verificationId: String, forceResendingToken: PhoneAuthProvider.ForceResendingToken) {
                storedVerificationId = verificationId
                resendToken = forceResendingToken
            }

            override fun onVerificationCompleted(phoneAuthCredential: PhoneAuthCredential) {
               // Toast.makeText(mContext, "이미 가입된 번호입니다.", Toast.LENGTH_SHORT).show()
            }

            override fun onVerificationFailed(e: FirebaseException) {

                if (e is FirebaseAuthInvalidCredentialsException) {
                    Toast.makeText(mContext, "잘못된 번호입니다.", Toast.LENGTH_SHORT).show()
                    // Invalid request
                } else if (e is FirebaseTooManyRequestsException) {
                    Toast.makeText(mContext, "제한 초과.", Toast.LENGTH_SHORT).show()
                    // The SMS quota for the project has been exceeded
                }

            }
        }
    }

        override fun onCreate(savedInstanceState: Bundle?) {
            super.onCreate(savedInstanceState)
            setContentView(R.layout.activity_sign_up)

            auth = Firebase.auth
            auth.setLanguageCode("ko")

            binding = DataBindingUtil.setContentView(this,R.layout.activity_sign_up)
            setActionBar()

            binding.signUpPhoneNumber.addTextChangedListener(object : TextWatcher{
                override fun beforeTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
                }

                override fun onTextChanged(p0: CharSequence?, start: Int, count: Int, after: Int) {
                    if (p0!!.length == 11) {
                        setCustomBtn(binding.signUpPhoneNumberCertfyBtn,R.drawable.white_btn,R.color.black,true,"인증번호" )
                    } else {
                        setCustomBtn(binding.signUpPhoneNumberCertfyBtn,R.drawable.default_btn,R.color.text_gray,false,"인증번호" )
                    }
                }

                override fun afterTextChanged(p0: Editable?) {
                    if (p0!!.length == 11) {
                        setCustomBtn(binding.signUpPhoneNumberCertfyBtn,R.drawable.white_btn,R.color.black,true,"인증번호" )
                    } else {
                        setCustomBtn(binding.signUpPhoneNumberCertfyBtn,R.drawable.default_btn,R.color.text_gray,false,"인증번호" )
                    }
                }
            })

            binding.signUpPhoneNumberCertfyBtn.setOnClickListener {
                if (binding.signUpPhoneNumberCertfyBtn.text == "인증번호") {
                    setCustomBtn(binding.signUpPhoneNumberCertfyBtn, R.drawable.white_btn, R.color.black, true, "다시받기")

                    binding.signUpPhoneNumber.isEnabled = false

                    binding.certifyBtn.visibility = View.VISIBLE
                    binding.signUpCertyfyNum.visibility = View.VISIBLE

                    if (resendToken == null) {
                        sendVerifyMsg(binding.signUpPhoneNumber.text.toString())
                    } else {
                        reSendVerifyMsg(binding.signUpPhoneNumber.text.toString())
                    }

                } else if (binding.signUpPhoneNumberCertfyBtn.text == "다시받기") {
                    setCustomBtn(binding.signUpPhoneNumberCertfyBtn, R.drawable.white_btn, R.color.black, false, "인증번호")
                    setCustomBtn(binding.signUpBtn, R.drawable.default_btn, R.color.text_gray, false, "가입하기")

                    binding.signUpPhoneNumber.text = null
                    binding.signUpPhoneNumber.isEnabled = true

                    binding.signUpCertyfyNum.text = null
                    binding.certifyBtn.visibility = View.INVISIBLE
                    binding.signUpCertyfyNum.visibility = View.INVISIBLE
                }
            }

            binding.certifyBtn.setOnClickListener {
                signInWithPhoneVerifyCode(binding.signUpCertyfyNum.text.toString())
            }
            binding.signUpBtn.setOnClickListener{
                val intent = Intent(applicationContext, LoginActivity::class.java)
                startActivity(intent)
            }
        }
    private fun setActionBar() {
        setSupportActionBar(binding.toolbar)
        supportActionBar?.title = null
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
    }

        override fun onOptionsItemSelected(item: MenuItem): Boolean {
            when(item.itemId){
                android.R.id.home -> {
                    finish()
                }
            }
            return super.onOptionsItemSelected(item)
        }


        private fun setCustomBtn(btn: Button,backgroundId : Int,textColorId : Int, isClickable : Boolean = true, text : String = ""){
            btn.isClickable = isClickable
            btn.setBackgroundResource(backgroundId)
            btn.setTextColor(resources.getColor(textColorId))
            if(isClickable) {
                val clickableFontType = resources.getFont(R.font.notosnanskr_bold)
                btn.typeface = clickableFontType
                btn.text = text
            } else {
                val unClickableFontType = resources.getFont(R.font.notosnanskr_reguler)
                btn.typeface = unClickableFontType
                btn.text = text
            }
        }

    private fun sendVerifyMsg(phoneNumber: String){
        Log.d("ss","send"+ phoneNumber)
        val options = PhoneAuthOptions.newBuilder(auth)
            .setPhoneNumber("+82"+ phoneNumber.substring(1))
            .setTimeout(120L,java.util.concurrent.TimeUnit.SECONDS)
            .setActivity(this)
            .setCallbacks(callbacks)
            .build()
        PhoneAuthProvider.verifyPhoneNumber(options)
    }

    private fun reSendVerifyMsg(phoneNumber: String) {
        val optionsBuilder = PhoneAuthOptions.newBuilder(auth)
            .setPhoneNumber("+82"+ phoneNumber.substring(1))
            .setTimeout(120L, java.util.concurrent.TimeUnit.SECONDS)
            .setActivity(this)
            .setCallbacks(callbacks)
            optionsBuilder.setForceResendingToken(resendToken!!)
        PhoneAuthProvider.verifyPhoneNumber(optionsBuilder.build())
    }

    private fun signInWithPhoneVerifyCode(userVerifyCode : String) {
        val credential = PhoneAuthProvider.getCredential(storedVerificationId?:"", userVerifyCode)
        auth.signInWithCredential(credential)
            .addOnCompleteListener(this) { task ->
                if (task.isSuccessful) {
                    Toast.makeText(this, "인증 성공",Toast.LENGTH_SHORT).show()
                    setCustomBtn(binding.signUpBtn, R.drawable.round_btn_filled, R.color.white, true, "가입하기")
                    val user = task.result?.user
                } else {
                    Toast.makeText(this, "인증 실패",Toast.LENGTH_SHORT).show()
                }
            }
    }

}


