/*
 * Copyright (C) 2013 Code Here Now - A subsidiary of Mobs & Geeks
 *
 * Licensed under the Apache License, Version 2.0 (the "License"); you may not use this file 
 * except in compliance with the License. You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software distributed under the 
 * License is distributed on an "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, 
 * either express or implied. See the License for the specific language governing permissions and 
 * limitations under the License.
 */

package com.codeherenow.trafficlights;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

public class TrafficLightsActivity extends Activity implements View.OnClickListener{

    private ImageView redLight;
    private ImageView yellowLight;
    private ImageView greenLight;

    private Button redButton;
    private Button yellowButton;
    private Button greenButton;

    private int lightStatus = 0;

    @Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.traffic_lights);

        //Assign Lights to the Resource
        redLight = (ImageView) findViewById(R.id.red_light);
        yellowLight = (ImageView) findViewById(R.id.yellow_light);
        greenLight = (ImageView) findViewById(R.id.green_light);

        //Assign Buttons to the Resource
        redButton = (Button) findViewById(R.id.red_button);
        yellowButton = (Button) findViewById(R.id.yellow_button);
        greenButton = (Button) findViewById(R.id.green_button);

        //Init the OnClickListener
        redButton.setOnClickListener(this);
        yellowButton.setOnClickListener(this);
        greenButton.setOnClickListener(this);

        redLight.setOnClickListener(this);
        yellowLight.setOnClickListener(this);
        greenLight.setOnClickListener(this);

        //When Program opens it defaults to the red light
        turnOnRedLight();
	}

    @Override
    public void onClick(View v) {
        //Turn of all lights when the button is clicked before turning any on
        turnLightsOff();
        //Now turn on the light for the button you hit

        //Switch Statement to turn lights on/off
        switch(v.getId()){
            case R.id.red_button:
                if(lightStatus == 1){
                    turnLightsOff();
                    displayStatus();
                    lightStatus = 0;
                }else{
                    turnOnRedLight();
                    displayStatus();
                }
                break;
            case R.id.red_light:
                if(lightStatus == 1){
                    turnLightsOff();
                    displayStatus();
                    lightStatus = 0;
                }else{
                    turnOnRedLight();
                    displayStatus();
                }
                break;
            case R.id.yellow_button:
                if(lightStatus == 2){
                    turnLightsOff();
                    lightStatus = 0;
                }else{
                turnOnYellowLight();
                displayStatus();
                }
                break;
            case R.id.yellow_light:
                if(lightStatus == 2){
                    turnLightsOff();
                    lightStatus = 0;
                }else{
                    turnOnYellowLight();
                    displayStatus();
                }
                break;
            case R.id.green_button:
                if(lightStatus == 3){
                    turnLightsOff();
                    lightStatus = 0;
                }else {
                    turnOnGreenLight();
                    displayStatus();
                }
                break;
            case R.id.green_light:
                if(lightStatus == 3){
                    turnLightsOff();
                    lightStatus = 0;
                }else{
                    turnOnGreenLight();
                    displayStatus();
                }
                break;
        }

        /* If Statement to turn lights On/Off
        if(v == redButton){
                turnOnRedLight();
        }else if(v == redLight){
                turnOnRedLight();
        }else if(v == yellowButton){
                turnOnYellowLight();
        }else if(v ==yellowLight) {
                turnOnYellowLight();
        }else if(v == greenButton){
                turnOnGreenLight();
        }else if(v == greenLight){
                turnOnGreenLight();
        }
        */
    }

    private void turnLightsOff() {
        redLight.setImageResource(R.drawable.light_off);
        yellowLight.setImageResource(R.drawable.light_off);
        greenLight.setImageResource(R.drawable.light_off);
    }

    private void turnOnRedLight() {
        lightStatus = 1;
        redLight.setImageResource(R.drawable.red_on);
    }
    private void turnOnYellowLight() {
        lightStatus = 2;
        yellowLight.setImageResource(R.drawable.yellow_on);
    }
    private void turnOnGreenLight() {
        lightStatus = 3;
        greenLight.setImageResource(R.drawable.green_on);
    }

    public void displayStatus(){
        //Will Display which light is being clicked on (red = 1, yellow = 2, green = 3)
        //Toast.makeText(getApplicationContext(), String.valueOf(lightStatus), Toast.LENGTH_SHORT).show();
    }
}
