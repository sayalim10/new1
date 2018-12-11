package com.devn.vendor.utils;

import android.content.Context;
import android.support.annotation.Nullable;
import android.support.design.widget.TextInputLayout;
import android.support.v4.content.ContextCompat;
import android.util.AttributeSet;
import android.widget.EditText;

import com.devn.vendor.R;


/**
 * Created by Nitin Kalokhe on 12/20/2016
 * * you can contact me at : nitin3kalokhe@gmail.com
 */
public class MyTextInputLayout extends TextInputLayout {

    private Context mContext;

    public MyTextInputLayout(Context context) {
        super(context);
        this.mContext = context;
    }

    public MyTextInputLayout(Context context, AttributeSet attrs) {
        super(context, attrs);
        this.mContext = context;
    }

    public MyTextInputLayout(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        this.mContext = context;
    }

    @Override
    protected void drawableStateChanged() {
        super.drawableStateChanged();
        final EditText edtTxt = getEditText();
        if (edtTxt != null)
            edtTxt.setBackground(ContextCompat.getDrawable(this.mContext, R.drawable.selector_edittext));
    }

    @Override
    public void setError(@Nullable CharSequence error) {
        super.setError(error);
        final EditText edtTxt = getEditText();
        if (edtTxt != null)
            edtTxt.setBackground(ContextCompat.getDrawable(this.mContext, R.drawable.selector_edittext));
    }
}
