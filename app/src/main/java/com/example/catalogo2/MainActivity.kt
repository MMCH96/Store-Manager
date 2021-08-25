package com.example.catalogo2

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.EditText
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.catalogo2.databinding.ActivityMainBinding
import com.example.catalogo2.databinding.ActivityVisorDatosBinding
import com.example.catalogo2.databinding.LectorBinding
import kotlinx.android.synthetic.main.activity_main.*
import java.util.ArrayList
import com.google.zxing.integration.android.IntentIntegrator
import kotlinx.android.synthetic.main.lector.*

class MainActivity : AppCompatActivity() {

    private lateinit var binding1: LectorBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding1 = LectorBinding.inflate(layoutInflater)
        setContentView(binding1.root)

        binding1.btnEscaner.setOnClickListener { initScanner() }
        binding1.btnBuscar.setOnClickListener{val intent = Intent(this,Lector::class.java)
            startActivity(intent)}
    }

    private fun initScanner(){
        IntentIntegrator(this).initiateScan()
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        val result = IntentIntegrator.parseActivityResult(requestCode,resultCode,data)

        if(result != null){
            if(result == null)
            {
                Toast.makeText(this, "Cancelado", Toast.LENGTH_SHORT).show()
            }else{
                binding1.txtValor.setText(result.contents)
            }
        }else{
            super.onActivityResult(requestCode, resultCode, data)
        }


    }



}