package io.conversioncalculator

import android.app.Activity
import android.os.Bundle
import android.text.Editable
import android.text.SpannableStringBuilder
import android.text.TextWatcher
import android.util.Log
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.EditText
import android.widget.Spinner
import androidx.appcompat.app.AppCompatActivity
import io.conversioncalculator.databinding.ActivityMainBinding


class MainActivity : AppCompatActivity(), View.OnClickListener {
    lateinit var mainspinner:Spinner
    lateinit var binding:ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        mainspinner=findViewById<Spinner>(R.id.mainSpinner)
        /*val items: ArrayList<String> = ArrayList()
        items.add("Please select an option")
        items.add("Item 4")
        items.add("Item 5")
        val adapter = ArrayAdapter(this, android.R.layout.simple_spinner_item, items)
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
        mainspinner.adapter = adapter
        mainspinner.onItemSelectedListener = object:AdapterView.OnItemSelectedListener{
            override fun onItemSelected(
                parent: AdapterView<*>?,
                view: View?,
                position: Int,
                id: Long
            ) {
                if(adapter.getItemId(-1).toString().equals("Please select an option")){

                    adapter.remove("Please select an option")
                }

                adapter.notifyDataSetChanged()
            }

            override fun onNothingSelected(parent: AdapterView<*>?) {
                TODO("Not yet implemented")
            }
        }*/
        var unitList= arrayListOf("")
        val adapter = ArrayAdapter(this, android.R.layout.simple_spinner_item, unitList)
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
        binding.firstSpinner.adapter=adapter
        binding.secondSpinner.adapter=adapter
        mainspinner.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
            override fun onItemSelected(parent: AdapterView<*>, view: View?, position: Int, id: Long) {
                when (position) {
                    0 -> {
                        unitList.clear()
                        adapter.notifyDataSetChanged()
                    }
                    1 -> {
                        unitList.clear()
                        unitList.add("KM")
                        unitList.add("M")
                        unitList.add("CM")
                        unitList.add("INCH")
                        adapter.notifyDataSetChanged()
                    }
                    2 -> {
                        unitList.clear()
                        unitList.add("GRAM")
                        unitList.add("KILOGRAM")
                        unitList.add("LB")
                        adapter.notifyDataSetChanged()
                    }
                    3 -> {
                        unitList.clear()
                        unitList.add("LITRE")
                        unitList.add("MILILITRE")
                        unitList.add("GALLON")
                        adapter.notifyDataSetChanged()
                    }
                    4 -> {
                        unitList.clear()
                        unitList.add("KELVIN")
                        unitList.add("CELSIUS")
                        unitList.add("FAHRENHEIT")
                        adapter.notifyDataSetChanged()
                    }
                }
            }
            override fun onNothingSelected(parent: AdapterView<*>) {
                // Do nothing
            }
        }
        binding.Submit.setOnClickListener {
            UpdateDisplay()
        }

    }
    override fun onClick(v:View?){

    }
    fun UpdateDisplay(){
        if (binding.firstSpinner.selectedItem.toString().equals("KM") && binding.secondSpinner.selectedItem.toString().equals("M") ){

            binding.secondBox.text= (binding.firstBox.editableText.toString().toDouble()*1000).toString()
        }
        else if (binding.firstSpinner.selectedItem.toString().equals("KM") && binding.secondSpinner.selectedItem.toString().equals("CM") ){

            binding.secondBox.text= (binding.firstBox.editableText.toString().toDouble()*100000).toString()
        }
        else if (binding.firstSpinner.selectedItem.toString().equals("KM") && binding.secondSpinner.selectedItem.toString().equals("INCH") ){

            binding.secondBox.text= (binding.firstBox.editableText.toString().toDouble()*39370.1).toString()
        }
        else if (binding.firstSpinner.selectedItem.toString().equals("KM") && binding.secondSpinner.selectedItem.toString().equals("KM") ){

            binding.secondBox.text= (binding.firstBox.editableText.toString().toDouble()*1).toString()
        }
        else if (binding.firstSpinner.selectedItem.toString().equals("M") && binding.secondSpinner.selectedItem.toString().equals("M") ){

            binding.secondBox.text= (binding.firstBox.editableText.toString().toDouble()*1).toString()
        }
        else if (binding.firstSpinner.selectedItem.toString().equals("M") && binding.secondSpinner.selectedItem.toString().equals("CM") ){

            binding.secondBox.text= (binding.firstBox.editableText.toString().toDouble()*100).toString()
        }
        else if (binding.firstSpinner.selectedItem.toString().equals("M") && binding.secondSpinner.selectedItem.toString().equals("INCH") ){

            binding.secondBox.text= (binding.firstBox.editableText.toString().toDouble()*39.3701).toString()
        }
        else if (binding.firstSpinner.selectedItem.toString().equals("M") && binding.secondSpinner.selectedItem.toString().equals("KM") ){

            binding.secondBox.text= (binding.firstBox.editableText.toString().toDouble()*0.001).toString()
        }
        else if (binding.firstSpinner.selectedItem.toString().equals("CM") && binding.secondSpinner.selectedItem.toString().equals("CM") ){

            binding.secondBox.text= (binding.firstBox.editableText.toString().toDouble()*1).toString()
        }
        else if (binding.firstSpinner.selectedItem.toString().equals("CM") && binding.secondSpinner.selectedItem.toString().equals("M") ){

            binding.secondBox.text= (binding.firstBox.editableText.toString().toDouble()*0.01).toString()
        }
        else if (binding.firstSpinner.selectedItem.toString().equals("CM") && binding.secondSpinner.selectedItem.toString().equals("INCH") ){

            binding.secondBox.text= (binding.firstBox.editableText.toString().toDouble()*0.393701).toString()
        }
        else if (binding.firstSpinner.selectedItem.toString().equals("CM") && binding.secondSpinner.selectedItem.toString().equals("KM") ){

            binding.secondBox.text= (binding.firstBox.editableText.toString().toDouble()*0.00001).toString()
        }
        else if (binding.firstSpinner.selectedItem.toString().equals("INCH") && binding.secondSpinner.selectedItem.toString().equals("INCH") ){

            binding.secondBox.text= (binding.firstBox.editableText.toString().toDouble()*1).toString()
        }
        else if (binding.firstSpinner.selectedItem.toString().equals("INCH") && binding.secondSpinner.selectedItem.toString().equals("CM") ){

            binding.secondBox.text= (binding.firstBox.editableText.toString().toDouble()*2.54).toString()
        }
        else if (binding.firstSpinner.selectedItem.toString().equals("INCH") && binding.secondSpinner.selectedItem.toString().equals("M") ){

            binding.secondBox.text= (binding.firstBox.editableText.toString().toDouble()*0.0254).toString()
        }
        else if (binding.firstSpinner.selectedItem.toString().equals("INCH") && binding.secondSpinner.selectedItem.toString().equals("KM") ){

            binding.secondBox.text= (binding.firstBox.editableText.toString().toDouble()*0.0000254).toString()
        }
        else if (binding.firstSpinner.selectedItem.toString().equals("GRAM") && binding.secondSpinner.selectedItem.toString().equals("GRAM") ){

            binding.secondBox.text= (binding.firstBox.editableText.toString().toDouble()*1).toString()
        }
        else if (binding.firstSpinner.selectedItem.toString().equals("GRAM") && binding.secondSpinner.selectedItem.toString().equals("KILOGRAM") ){

            binding.secondBox.text= (binding.firstBox.editableText.toString().toDouble()*0.001).toString()
        }
        else if (binding.firstSpinner.selectedItem.toString().equals("GRAM") && binding.secondSpinner.selectedItem.toString().equals("LB") ){

            binding.secondBox.text= (binding.firstBox.editableText.toString().toDouble()*0.00220462).toString()
        }
        else if (binding.firstSpinner.selectedItem.toString().equals("KILOGRAM") && binding.secondSpinner.selectedItem.toString().equals("KILOGRAM") ){

            binding.secondBox.text= (binding.firstBox.editableText.toString().toDouble()*1).toString()
        }
        else if (binding.firstSpinner.selectedItem.toString().equals("KILOGRAM") && binding.secondSpinner.selectedItem.toString().equals("GRAM") ){

            binding.secondBox.text= (binding.firstBox.editableText.toString().toDouble()*1000).toString()
        }
        else if (binding.firstSpinner.selectedItem.toString().equals("KILOGRAM") && binding.secondSpinner.selectedItem.toString().equals("LB") ){

            binding.secondBox.text= (binding.firstBox.editableText.toString().toDouble()*2.20462).toString()
        }
        else if (binding.firstSpinner.selectedItem.toString().equals("LB") && binding.secondSpinner.selectedItem.toString().equals("LB") ){

            binding.secondBox.text= (binding.firstBox.editableText.toString().toDouble()*1).toString()
        }
        else if (binding.firstSpinner.selectedItem.toString().equals("LB") && binding.secondSpinner.selectedItem.toString().equals("KILOGRAM") ){

            binding.secondBox.text= (binding.firstBox.editableText.toString().toDouble()*0.453592).toString()
        }
        else if (binding.firstSpinner.selectedItem.toString().equals("LB") && binding.secondSpinner.selectedItem.toString().equals("GRAM") ){

            binding.secondBox.text= (binding.firstBox.editableText.toString().toDouble()*453.592).toString()
        }
        else if (binding.firstSpinner.selectedItem.toString().equals("LITRE") && binding.secondSpinner.selectedItem.toString().equals("LITRE") ){

            binding.secondBox.text= (binding.firstBox.editableText.toString().toDouble()*1).toString()
        }
        else if (binding.firstSpinner.selectedItem.toString().equals("LITRE") && binding.secondSpinner.selectedItem.toString().equals("MILILITRE") ){

            binding.secondBox.text= (binding.firstBox.editableText.toString().toDouble()*1000).toString()
        }
        else if (binding.firstSpinner.selectedItem.toString().equals("LITRE") && binding.secondSpinner.selectedItem.toString().equals("GALLON") ){

            binding.secondBox.text= (binding.firstBox.editableText.toString().toDouble()*0.264172).toString()
        }
        else if (binding.firstSpinner.selectedItem.toString().equals("MILILITRE") && binding.secondSpinner.selectedItem.toString().equals("MILILITRE") ){

            binding.secondBox.text= (binding.firstBox.editableText.toString().toDouble()*1).toString()
        }
        else if (binding.firstSpinner.selectedItem.toString().equals("MILILITRE") && binding.secondSpinner.selectedItem.toString().equals("LITRE") ){

            binding.secondBox.text= (binding.firstBox.editableText.toString().toDouble()*0.001).toString()
        }
        else if (binding.firstSpinner.selectedItem.toString().equals("MILILITRE") && binding.secondSpinner.selectedItem.toString().equals("GALLON") ){

            binding.secondBox.text= (binding.firstBox.editableText.toString().toDouble()*0.000264172).toString()
        }
        else if (binding.firstSpinner.selectedItem.toString().equals("GALLON") && binding.secondSpinner.selectedItem.toString().equals("MILILITRE") ){

            binding.secondBox.text= (binding.firstBox.editableText.toString().toDouble()*3785.41).toString()
        }
        else if (binding.firstSpinner.selectedItem.toString().equals("GALLON") && binding.secondSpinner.selectedItem.toString().equals("LITRE") ){

            binding.secondBox.text= (binding.firstBox.editableText.toString().toDouble()*3.78541).toString()
        }
        else if (binding.firstSpinner.selectedItem.toString().equals("GALLON") && binding.secondSpinner.selectedItem.toString().equals("GALLON") ){

            binding.secondBox.text= (binding.firstBox.editableText.toString().toDouble()*1).toString()
        }

        else if (binding.firstSpinner.selectedItem.toString().equals("KELVIN") && binding.secondSpinner.selectedItem.toString().equals("KELVIN") ){

            binding.secondBox.text= (binding.firstBox.editableText.toString().toDouble()*1).toString()
        }
        else if (binding.firstSpinner.selectedItem.toString().equals("KELVIN") && binding.secondSpinner.selectedItem.toString().equals("CELSIUS") ){

            binding.secondBox.text= (binding.firstBox.editableText.toString().toDouble()-273.15).toString()
        }
        else if (binding.firstSpinner.selectedItem.toString().equals("KELVIN") && binding.secondSpinner.selectedItem.toString().equals("FAHRENHEIT") ){

            binding.secondBox.text= ((binding.firstBox.editableText.toString().toDouble()- 273.15)*1.8 + 32).toString()
        }
        else if (binding.firstSpinner.selectedItem.toString().equals("CELSIUS") && binding.secondSpinner.selectedItem.toString().equals("KELVIN") ){

            binding.secondBox.text= (binding.firstBox.editableText.toString().toDouble()+273.15).toString()
        }
        else if (binding.firstSpinner.selectedItem.toString().equals("CELSIUS") && binding.secondSpinner.selectedItem.toString().equals("CELSIUS") ){

            binding.secondBox.text= (binding.firstBox.editableText.toString().toDouble()*1).toString()
        }
        else if (binding.firstSpinner.selectedItem.toString().equals("CELSIUS") && binding.secondSpinner.selectedItem.toString().equals("FAHRENHEIT") ){

            binding.secondBox.text= (binding.firstBox.editableText.toString().toDouble()*1.8 + 32).toString()
        }
        else if (binding.firstSpinner.selectedItem.toString().equals("FAHRENHEIT") && binding.secondSpinner.selectedItem.toString().equals("KELVIN") ){

            binding.secondBox.text= (((binding.firstBox.editableText.toString().toDouble()- 32) * 5/9)+273.15).toString()
        }
        else if (binding.firstSpinner.selectedItem.toString().equals("FAHRENHEIT") && binding.secondSpinner.selectedItem.toString().equals("FAHRENHEIT") ){

            binding.secondBox.text= (binding.firstBox.editableText.toString().toDouble()*1).toString()
        }
        else if (binding.firstSpinner.selectedItem.toString().equals("FAHRENHEIT") && binding.secondSpinner.selectedItem.toString().equals("CELSIUS") ){

            binding.secondBox.text= ((binding.firstBox.editableText.toString().toDouble()- 32) * 5/9).toString()
        }
    }
}
