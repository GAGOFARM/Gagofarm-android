package com.foo.gagofarm

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.view.MenuItem
import android.widget.Button
import androidx.databinding.DataBindingUtil
import com.foo.gagofarm.databinding.ActivitySignUpBinding

class SignUpActivity : AppCompatActivity() {
    private lateinit var binding: ActivitySignUpBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sign_up)

        binding = DataBindingUtil.setContentView(this,R.layout.activity_sign_up)

        setSupportActionBar(binding.toolbar)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        binding.signUpPhoneNumber.addTextChangedListener(object : TextWatcher{
            override fun beforeTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
                TODO("Not yet implemented")
            }

            override fun onTextChanged(p0: CharSequence?, start: Int, before: Int, count: Int) {
                 if (count == 11) {
                     setCustomBtn(binding.certifyBtn,R.drawable.white_btn,R.color.black,true,"다시받기" )
                 } else {
                     setCustomBtn(binding.certifyBtn,R.drawable.default_btn,R.color.text_gray,false,"인증번호" )
                 }
                TODO("Not yet implemented")
            }

            override fun afterTextChanged(p0: Editable?) {
                if (p0!!.length == 11) {
                    setCustomBtn(binding.certifyBtn,R.drawable.white_btn,R.color.black,true,"다시받기" )
                } else {
                    setCustomBtn(binding.certifyBtn,R.drawable.default_btn,R.color.text_gray,false,"인증번호" )
                }
                TODO("Not yet implemented")
            }

        })
    }


    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when(item.itemId){
            android.R.id.home -> {
                finish()
            }
        }
        return super.onOptionsItemSelected(item)
    }

    fun setCustomBtn(btn: Button,backgroundId : Int,textColorId : Int, flag : Boolean = true, text : String = ""){
        btn.setClickable(flag)
        btn.setBackgroundResource(backgroundId)
        btn.setTextColor(resources.getColor(textColorId))
        if( text != "" ) {
            btn.setText(text)
        }
    }
}