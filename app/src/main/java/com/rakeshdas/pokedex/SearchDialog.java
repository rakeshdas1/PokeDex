package com.rakeshdas.pokedex;

import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Toast;

/**
 * Created by Rakesh Das on 001 Apr 01 2017.
 */

public class SearchDialog extends Dialog {
    private Context context;
    private ImageButton searchBtn;
    private EditText searchBar;

    public SearchDialog(@NonNull Context context) {
        super(context);
        this.context = context;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        searchBar = (EditText) findViewById(R.id.search_bar);
        searchBtn = (ImageButton) findViewById(R.id.search_btn);
        searchBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(context, searchBar.getText(), Toast.LENGTH_SHORT).show();
            }
        });
        super.onCreate(savedInstanceState);
    }
}
