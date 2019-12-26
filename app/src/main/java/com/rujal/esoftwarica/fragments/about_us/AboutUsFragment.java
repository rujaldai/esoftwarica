package com.rujal.esoftwarica.fragments.about_us;


import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProviders;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView;
import android.webkit.WebViewClient;

import com.rujal.esoftwarica.R;

public class AboutUsFragment extends Fragment {

    private AboutUsModel aboutUsModel;
    private WebView webview;


    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        aboutUsModel = ViewModelProviders.of(this).get(AboutUsModel.class);
        View view = inflater.inflate(R.layout.fragment_about_us, container, false);

        webview=view.findViewById(R.id.webView);
        webview.getSettings().setJavaScriptEnabled(true);
       // webview.getSettings().setBlockNetworkLoads (false);
        webview.setWebViewClient(new WebViewClient());
        webview.loadUrl("https://softwarica.edu.np/");
        return view;
    }

}
