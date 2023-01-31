package ui;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import algonquin.cst2335.juna0006.databinding.ActivityMainBinding;
import data.MainViewModel;


public class MainActivity extends AppCompatActivity {
    private MainViewModel model;
    private ActivityMainBinding variableBinding;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        model = new ViewModelProvider(this).get(MainViewModel.class);

        variableBinding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(variableBinding.getRoot());
        model.isSelected.observe(this,selected ->{
            variableBinding.mySwitch.setChecked(selected);
            variableBinding.myCheckBox.setChecked(selected);
            variableBinding.myRadioButton.setChecked(selected);
        });


        Object isChecked;
        CompoundButton.OnCheckedChangeListener btn;
        variableBinding.mySwitch.setOnCheckedChangeListener(btn,isChecked) -> {
            Toast
                    .makeText(MainActivity.this,"This is the message on screen",Toast.LENGTH_LONG)
                    .show();
        });

         variableBinding.textview.setText(model.editString);
         variableBinding.mybutton.setOnClickListener( new View.OnClickListener(){

            @Override
            public void onClick(View v){
                model.editString= variableBinding.myedittext.getText().toString();
               variableBinding.textview.setText("Your edit text has:"+ model.editString);
                variableBinding.mybutton.setText("Your edit text has:"+model.editString);
              variableBinding.myedittext.setText("Your edit text has:"+ model.editString);
            }

                });
    }
}