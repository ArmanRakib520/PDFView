package com.mcc.pdfview;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class PdfViewerActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pdf_viewer);

        Intent intent = getIntent();
        String name = intent.getStringExtra("keyName");
        String path = intent.getStringExtra("keyPath");

        setTitle(name);

        PdfFragment fragment = new PdfFragment();
        Bundle bundle = new Bundle();
        bundle.putString("keyPath", path);
        fragment.setArguments(bundle);

        getSupportFragmentManager().beginTransaction()
                .add(R.id.frame, fragment, "Pdf renderer")
                .commit();
    }
}
