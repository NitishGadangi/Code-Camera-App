package com.nitish.codemakerapp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.util.Log;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.vision.Detector;
import com.google.firebase.ml.vision.FirebaseVision;
import com.google.firebase.ml.vision.common.FirebaseVisionImage;
import com.google.firebase.ml.vision.document.FirebaseVisionDocumentText;
import com.google.firebase.ml.vision.document.FirebaseVisionDocumentTextRecognizer;
import com.google.firebase.ml.vision.text.FirebaseVisionText;
import com.google.firebase.ml.vision.text.FirebaseVisionTextRecognizer;

public class MainActivity extends AppCompatActivity {
    TextView textView;
    ProgressBar progressBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        textView = findViewById(R.id.textView);
        progressBar = findViewById(R.id.progressBar);

        FirebaseVisionImage firebaseVisionImage = FirebaseVisionImage.fromBitmap(BitmapFactory.decodeResource(getResources(), R.drawable.demo2));
        FirebaseVisionTextRecognizer firebaseVisionTextRecognizer = FirebaseVision.getInstance().getOnDeviceTextRecognizer();
        firebaseVisionTextRecognizer.processImage(firebaseVisionImage).addOnSuccessListener(new OnSuccessListener<FirebaseVisionText>() {
            @Override
            public void onSuccess(FirebaseVisionText firebaseVisionText) {
                Toast.makeText(MainActivity.this, "Success", Toast.LENGTH_SHORT).show();
                Log.i("SUCCC",firebaseVisionText.getText());
                textView.setText(firebaseVisionText.getText());
            }
        }).addOnFailureListener(new OnFailureListener() {
            @Override
            public void onFailure(@NonNull Exception e) {
                Toast.makeText(MainActivity.this, "Fail", Toast.LENGTH_SHORT).show();
                Log.i("SUCCC","Fail");
            }
        });

//        FirebaseVisionDocumentTextRecognizer firebaseVisionDocumentTextRecognizer = FirebaseVision.getInstance().getCloudDocumentTextRecognizer();
//        firebaseVisionDocumentTextRecognizer.processImage(firebaseVisionImage).addOnSuccessListener(new OnSuccessListener<FirebaseVisionDocumentText>() {
//            @Override
//            public void onSuccess(FirebaseVisionDocumentText firebaseVisionDocumentText) {
//                Toast.makeText(MainActivity.this, "Success", Toast.LENGTH_SHORT).show();
//                Log.i("SUCCC",firebaseVisionDocumentText.getText());
//                textView.setText(firebaseVisionDocumentText.getText());
//            }
//        }).addOnFailureListener(new OnFailureListener() {
//            @Override
//            public void onFailure(@NonNull Exception e) {
//                Toast.makeText(MainActivity.this, "Fail", Toast.LENGTH_SHORT).show();
//                Log.i("SUCCC","Fail"+e.getMessage());
//            }
//        });



    }
}
