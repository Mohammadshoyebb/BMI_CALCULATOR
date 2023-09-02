package com.example.bmicalculator;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //    DECLARATION OF VARIABLES

        EditText heightft, heightinch,weight;
        TextView result;
        Button calcBMI;
        LinearLayout ll1;

        /*    ASSIGNING VALUES TO THE VARIABLES WHICH WE HAVE DECLARED ABOVE
              AND FOR THAT WE USE "findViewById(HERE WE PROVIDE ID LOCATION WITH ID NAME)"
         */

        heightft = findViewById(R.id.heigt_ft);
        heightinch = findViewById(R.id.height_inch);
        weight = findViewById(R.id.weightkg);
        calcBMI = findViewById(R.id.calculateBMI);
        result = findViewById(R.id.result);
        ll1 = findViewById(R.id.ll);

        /*   FOR OUR BUTTON TO PERFORM SOME TASK  WE USE LISTENER CLASS
             AND WE ALSO CREATE OBJECT OF LISTENER CLASS & onClickListener CLASS IS AN
             INTERFACE SO WE ALSO NEED TO OVER RIDE ITS "onClick" METHOD & THEN WE NEED DEFINE
             OR GIVE SET OF INSTRUCTIONS IN onClick METHOD TO PERFORM OUR TASK
         */


        calcBMI.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                /*  TO GET VALUES FROM EditText/User WE HAVE TO USE GETTER() AND USE TYPE CASTING AND CONVERT
                    CONVERT THE GIVEN CODE TO INTEGER USING parseInt()

                 */

                int wt_ft = Integer.parseInt(heightft.getText().toString());
                int wt_inch = Integer.parseInt(heightinch.getText().toString());
                int wgt = Integer.parseInt(weight.getText().toString());

                //  NOW WE NEED TO APPLY BMI FORMULA WHICH IS weight/height^2 & ITS SI UNIT IS KG/METER^2 SO WE ALSO HAVE TO CONVERT VALUES TO METERS

                int Total_inches = wt_ft*12 + wt_inch;

                double in_cm = Total_inches * 2.53;

                double meter = in_cm/100;

               double BMI = wgt/(meter*meter);

               if (BMI > 25) {
                   result.setText("YOU ARE OVERWEIGHT");

                   //  TO GET COLOUR FORM RESOURCE FILE WE NEED TO USE getResources().getColor(R.color."colorID"));

                   ll1.setBackgroundColor(getResources().getColor(R.color.A));
               }else if(BMI<18) {
                    result.setText("YOU ARE UNDERWEIGHT");
                    ll1.setBackgroundColor(getResources().getColor(R.color.B));
                }else {
                   result.setText("YOU ARE HEALTHY");
                   ll1.setBackgroundColor(getResources().getColor(R.color.C));
               }

            }
        });





    }
}