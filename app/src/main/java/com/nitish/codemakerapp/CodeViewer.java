package com.nitish.codemakerapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import io.github.kbiakov.codeview.CodeView;
import io.github.kbiakov.codeview.adapters.Options;
import io.github.kbiakov.codeview.classifier.CodeProcessor;
import io.github.kbiakov.codeview.highlight.ColorTheme;

public class CodeViewer extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_code_viewer);

        CodeView codeView = (CodeView) findViewById(R.id.code_view);

        CodeProcessor.init(this);

        codeView.setOptions(Options.Default.get(this)
                .withLanguage("python")
                .withCode(R.string.test_code)
                .withTheme(ColorTheme.MONOKAI));

        findViewById(R.id.btn_spotify).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(CodeViewer.this, "demo.py  Saved", Toast.LENGTH_SHORT).show();
            }
        });
    }
}
