package io.conversioncalculator

import android.content.Context
import android.os.Bundle
import android.text.TextUtils
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.EditText
import android.widget.Spinner
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity


class MainActivity : AppCompatActivity() {
    lateinit var mainspinner:Spinner
    lateinit var firstSpinner:Spinner
    lateinit var secondSpinner:Spinner
    lateinit var submit:Button
    lateinit var firstBox:EditText
    lateinit var secondBox:TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        //Pankaj - A00244692
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        mainspinner=findViewById<Spinner>(R.id.mainSpinner)
        firstSpinner = findViewById<Spinner>(R.id.firstSpinner)
        secondSpinner = findViewById<Spinner>(R.id.secondSpinner)
        submit = findViewById<Button>(R.id.Submit)
        firstBox = findViewById<EditText>(R.id.firstBox)
        secondBox = findViewById<TextView>(R.id.secondBox)
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
        firstSpinner.adapter=adapter
        secondSpinner.adapter=adapter
        // I got this code from chatGPT
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
        //I have make sure app will not crash on submit button and also put popup message if anything wrong is selected
        submit.setOnClickListener {
            val context: Context = applicationContext

            val text: CharSequence = "Please Select an Option First"
            val duration = Toast.LENGTH_SHORT
            var toast = Toast.makeText(context, text, duration)

            if(mainspinner.selectedItem.toString().equals("Please select an option")) {

                toast.show()
            }else {
                if (TextUtils.isEmpty(firstBox.editableText)) {
                    toast = Toast.makeText(context, "Please Enter the Value First", duration)
                    toast.show()
                } else {
                    UpdateDisplay()
                }
            }
        }
    }
    //This function is to check which unit is selected in both spinner and then it will calculate entered value into the selected unit
    fun UpdateDisplay(){
        if (firstSpinner.selectedItem.toString().equals("KM") && secondSpinner.selectedItem.toString().equals("M") ){

            secondBox.text= (firstBox.editableText.toString().toDouble()*1000).toString()
        }
        else if (firstSpinner.selectedItem.toString().equals("KM") && secondSpinner.selectedItem.toString().equals("CM") ){

            secondBox.text= (firstBox.editableText.toString().toDouble()*100000).toString()
        }
        else if (firstSpinner.selectedItem.toString().equals("KM") && secondSpinner.selectedItem.toString().equals("INCH") ){

            secondBox.text= (firstBox.editableText.toString().toDouble()*39370.1).toString()
        }
        else if (firstSpinner.selectedItem.toString().equals("KM") && secondSpinner.selectedItem.toString().equals("KM") ){

            secondBox.text= (firstBox.editableText.toString().toDouble()*1).toString()
        }
        else if (firstSpinner.selectedItem.toString().equals("M") && secondSpinner.selectedItem.toString().equals("M") ){

            secondBox.text= (firstBox.editableText.toString().toDouble()*1).toString()
        }
        else if (firstSpinner.selectedItem.toString().equals("M") && secondSpinner.selectedItem.toString().equals("CM") ){

            secondBox.text= (firstBox.editableText.toString().toDouble()*100).toString()
        }
        else if (firstSpinner.selectedItem.toString().equals("M") && secondSpinner.selectedItem.toString().equals("INCH") ){

            secondBox.text= (firstBox.editableText.toString().toDouble()*39.3701).toString()
        }
        else if (firstSpinner.selectedItem.toString().equals("M") && secondSpinner.selectedItem.toString().equals("KM") ){

            secondBox.text= (firstBox.editableText.toString().toDouble()*0.001).toString()
        }
        else if (firstSpinner.selectedItem.toString().equals("CM") && secondSpinner.selectedItem.toString().equals("CM") ){

            secondBox.text= (firstBox.editableText.toString().toDouble()*1).toString()
        }
        else if (firstSpinner.selectedItem.toString().equals("CM") && secondSpinner.selectedItem.toString().equals("M") ){

            secondBox.text= (firstBox.editableText.toString().toDouble()*0.01).toString()
        }
        else if (firstSpinner.selectedItem.toString().equals("CM") && secondSpinner.selectedItem.toString().equals("INCH") ){

            secondBox.text= (firstBox.editableText.toString().toDouble()*0.393701).toString()
        }
        else if (firstSpinner.selectedItem.toString().equals("CM") && secondSpinner.selectedItem.toString().equals("KM") ){

            secondBox.text= (firstBox.editableText.toString().toDouble()*0.00001).toString()
        }
        else if (firstSpinner.selectedItem.toString().equals("INCH") && secondSpinner.selectedItem.toString().equals("INCH") ){

            secondBox.text= (firstBox.editableText.toString().toDouble()*1).toString()
        }
        else if (firstSpinner.selectedItem.toString().equals("INCH") && secondSpinner.selectedItem.toString().equals("CM") ){

            secondBox.text= (firstBox.editableText.toString().toDouble()*2.54).toString()
        }
        else if (firstSpinner.selectedItem.toString().equals("INCH") && secondSpinner.selectedItem.toString().equals("M") ){

            secondBox.text= (firstBox.editableText.toString().toDouble()*0.0254).toString()
        }
        else if (firstSpinner.selectedItem.toString().equals("INCH") && secondSpinner.selectedItem.toString().equals("KM") ){

            secondBox.text= (firstBox.editableText.toString().toDouble()*0.0000254).toString()
        }
        else if (firstSpinner.selectedItem.toString().equals("GRAM") && secondSpinner.selectedItem.toString().equals("GRAM") ){

            secondBox.text= (firstBox.editableText.toString().toDouble()*1).toString()
        }
        else if (firstSpinner.selectedItem.toString().equals("GRAM") && secondSpinner.selectedItem.toString().equals("KILOGRAM") ){

            secondBox.text= (firstBox.editableText.toString().toDouble()*0.001).toString()
        }
        else if (firstSpinner.selectedItem.toString().equals("GRAM") && secondSpinner.selectedItem.toString().equals("LB") ){

            secondBox.text= (firstBox.editableText.toString().toDouble()*0.00220462).toString()
        }
        else if (firstSpinner.selectedItem.toString().equals("KILOGRAM") && secondSpinner.selectedItem.toString().equals("KILOGRAM") ){

            secondBox.text= (firstBox.editableText.toString().toDouble()*1).toString()
        }
        else if (firstSpinner.selectedItem.toString().equals("KILOGRAM") && secondSpinner.selectedItem.toString().equals("GRAM") ){

            secondBox.text= (firstBox.editableText.toString().toDouble()*1000).toString()
        }
        else if (firstSpinner.selectedItem.toString().equals("KILOGRAM") && secondSpinner.selectedItem.toString().equals("LB") ){

            secondBox.text= (firstBox.editableText.toString().toDouble()*2.20462).toString()
        }
        else if (firstSpinner.selectedItem.toString().equals("LB") && secondSpinner.selectedItem.toString().equals("LB") ){

            secondBox.text= (firstBox.editableText.toString().toDouble()*1).toString()
        }
        else if (firstSpinner.selectedItem.toString().equals("LB") && secondSpinner.selectedItem.toString().equals("KILOGRAM") ){

            secondBox.text= (firstBox.editableText.toString().toDouble()*0.453592).toString()
        }
        else if (firstSpinner.selectedItem.toString().equals("LB") && secondSpinner.selectedItem.toString().equals("GRAM") ){

            secondBox.text= (firstBox.editableText.toString().toDouble()*453.592).toString()
        }
        else if (firstSpinner.selectedItem.toString().equals("LITRE") && secondSpinner.selectedItem.toString().equals("LITRE") ){

            secondBox.text= (firstBox.editableText.toString().toDouble()*1).toString()
        }
        else if (firstSpinner.selectedItem.toString().equals("LITRE") && secondSpinner.selectedItem.toString().equals("MILILITRE") ){

            secondBox.text= (firstBox.editableText.toString().toDouble()*1000).toString()
        }
        else if (firstSpinner.selectedItem.toString().equals("LITRE") && secondSpinner.selectedItem.toString().equals("GALLON") ){

            secondBox.text= (firstBox.editableText.toString().toDouble()*0.264172).toString()
        }
        else if (firstSpinner.selectedItem.toString().equals("MILILITRE") && secondSpinner.selectedItem.toString().equals("MILILITRE") ){

            secondBox.text= (firstBox.editableText.toString().toDouble()*1).toString()
        }
        else if (firstSpinner.selectedItem.toString().equals("MILILITRE") && secondSpinner.selectedItem.toString().equals("LITRE") ){

            secondBox.text= (firstBox.editableText.toString().toDouble()*0.001).toString()
        }
        else if (firstSpinner.selectedItem.toString().equals("MILILITRE") && secondSpinner.selectedItem.toString().equals("GALLON") ){

            secondBox.text= (firstBox.editableText.toString().toDouble()*0.000264172).toString()
        }
        else if (firstSpinner.selectedItem.toString().equals("GALLON") && secondSpinner.selectedItem.toString().equals("MILILITRE") ){

            secondBox.text= (firstBox.editableText.toString().toDouble()*3785.41).toString()
        }
        else if (firstSpinner.selectedItem.toString().equals("GALLON") && secondSpinner.selectedItem.toString().equals("LITRE") ){

            secondBox.text= (firstBox.editableText.toString().toDouble()*3.78541).toString()
        }
        else if (firstSpinner.selectedItem.toString().equals("GALLON") && secondSpinner.selectedItem.toString().equals("GALLON") ){

            secondBox.text= (firstBox.editableText.toString().toDouble()*1).toString()
        }

        else if (firstSpinner.selectedItem.toString().equals("KELVIN") && secondSpinner.selectedItem.toString().equals("KELVIN") ){

            secondBox.text= (firstBox.editableText.toString().toDouble()*1).toString()
        }
        else if (firstSpinner.selectedItem.toString().equals("KELVIN") && secondSpinner.selectedItem.toString().equals("CELSIUS") ){

            secondBox.text= (firstBox.editableText.toString().toDouble()-273.15).toString()
        }
        else if (firstSpinner.selectedItem.toString().equals("KELVIN") && secondSpinner.selectedItem.toString().equals("FAHRENHEIT") ){

            secondBox.text= ((firstBox.editableText.toString().toDouble()- 273.15)*1.8 + 32).toString()
        }
        else if (firstSpinner.selectedItem.toString().equals("CELSIUS") && secondSpinner.selectedItem.toString().equals("KELVIN") ){

            secondBox.text= (firstBox.editableText.toString().toDouble()+273.15).toString()
        }
        else if (firstSpinner.selectedItem.toString().equals("CELSIUS") && secondSpinner.selectedItem.toString().equals("CELSIUS") ){

            secondBox.text= (firstBox.editableText.toString().toDouble()*1).toString()
        }
        else if (firstSpinner.selectedItem.toString().equals("CELSIUS") && secondSpinner.selectedItem.toString().equals("FAHRENHEIT") ){

            secondBox.text= (firstBox.editableText.toString().toDouble()*1.8 + 32).toString()
        }
        else if (firstSpinner.selectedItem.toString().equals("FAHRENHEIT") && secondSpinner.selectedItem.toString().equals("KELVIN") ){

            secondBox.text= (((firstBox.editableText.toString().toDouble()- 32) * 5/9)+273.15).toString()
        }
        else if (firstSpinner.selectedItem.toString().equals("FAHRENHEIT") && secondSpinner.selectedItem.toString().equals("FAHRENHEIT") ){

            secondBox.text= (firstBox.editableText.toString().toDouble()*1).toString()
        }
        else if (firstSpinner.selectedItem.toString().equals("FAHRENHEIT") && secondSpinner.selectedItem.toString().equals("CELSIUS") ){

            secondBox.text= ((firstBox.editableText.toString().toDouble()- 32) * 5/9).toString()
        }
    }
}
