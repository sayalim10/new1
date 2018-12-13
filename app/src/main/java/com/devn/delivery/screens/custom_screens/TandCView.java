package com.devn.delivery.screens.custom_screens;

import android.app.Dialog;
import android.app.Service;
import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.text.Editable;
import android.text.Html;
import android.view.LayoutInflater;
import android.view.View;
import android.view.Window;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.devn.delivery.R;

import org.xml.sax.XMLReader;

/**
 * Created by Lenovo on 7/29/2018.
 */

public class TandCView {

    private Context mContext;
    private Dialog helpDialog = null;

    public TandCView(Context context) {
        this.mContext = context;
    }

    public void showDialog() {
        LayoutInflater inflater = (LayoutInflater) mContext.getSystemService(Service.LAYOUT_INFLATER_SERVICE);
        final View view = inflater.inflate(R.layout.t_and_c_dialog, null);

        initializeComponents(view);

        Dialog dlg = new Dialog(mContext);
        LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(
                LinearLayout.LayoutParams.MATCH_PARENT,
                LinearLayout.LayoutParams.MATCH_PARENT);
        dlg.requestWindowFeature(Window.FEATURE_NO_TITLE);
        dlg.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
        dlg.addContentView(view, params);
        dlg.show();
        helpDialog = dlg;

//        helpDialog = AlertView.getInstance().showDialog(mContext, view, "Do you need any assistance?");
        helpDialog.setCancelable(false);
    }

    private final String TandC_TEXT = "<div><strong><u>EatPM,</u><br />is the food providing company.</strong></div><div><ul>Your downloading and use of EatPM Mobile application developed by EatPM [\"software\"] and or surfing/using the systems/website of EatPM to view your <mention the application features>, and use of website of EatPM through the use of this software constitutes unconditional acceptance of all the terms and conditions [as stated herein below or as amended by EatPM from time to time] whereby you hereby agree and unconditionally undertake for the proper and rightful use of software only for the purpose of your viewing <our eatpm services>.,</ul></div><div><ul>Any changes/modifications/additions to made by EatPM to all the terms and conditions under this declaration shall be deemed to be part and parcel of all the terms and conditions under this declaration and undertaking by you without any necessity of any separate/specific approval by you.</ul></div><div><ul>Upon completion of the process of downloading and installation of the software on your mobile phone you are given a limited, non-exclusive, nontransferable, non-assignable, revocable, cancellable without any prior notice, license to use software of EatPM on your mobile phone so long as you are (i) the existing customer of EatPM, and (ii) you are Indian citizen, and (iii) You agree and acknowledge that the software is provided by EatPM on 'as is and what is basis' and EatPM does not make any warranty about the software or its utility or suitability of software for any specific purpose.</ul><ul>All assurances, accuracies, usability for a particular purpose, or other warranties of whatsoever nature, whether express or implied warranties with respect to the software are specifically excluded and disclaimed by EatPM. All software provided by EatPM to you shall be treated as 'Confidential Information' of EatPM and shall be returned back to EatPM once you ceased to be customer of EatPM and or once you do not have any valid and subsisting insurance policy issued by EatPM in your name. You shall use the software on your mobile phone at your own risk and agree not to blame or make EatPM liable or responsible for any malfunction/s, non-function or improper function that might be developed on your phone at any time now upon downloading or uploading this software, attempt to download or upload this software or at any time subsequently at a later time and EatPM is not in any way be responsible or liable to the customer for whatever reasons.</ul><ul><ul>In no event will EatPM be liable to you or to any of your legal heirs or to any third parties for any direct, indirect, incidental, consequential, special or exemplary damages or loss of profit, costs, expenses, claims, damages of whatsoever resulting from any use or misuse of this software. You shall have no rights or entitlements to the software except a limited, revocable, non-transferable and non-exclusive license to other EatPM users. The ownership of all software and all components and modules thereof (including all intellectual property rights therein) provided by EatPM to you shall always be exclusively owned and vested with EatPM. No part of this work may be copied, reproduced, or translated in any form or medium without the prior written consent of EatPM. EatPM reserves its right to withdraw the software at any time without prior notice and the customer shall not complain or have any grievance of whatsoever.</ul></ul><ul><ul><ul>The access provided through use of the software on your mobile are provided for your food requirements., and you shall not use the software in relation to or to process business activities or products of any third party, including any other food providing services and use of software also to some extent depends upon the user's environment, security features, mobile network connectivity, etc.,.</ul></ul></ul><ul><ul><ul><ul>You shall be liable to use the software in compliance with and subject to the provisions of Information Technology Act [IT Act] read with rules, orders, directions, notifications etc., and any amendments thereof, from time to time, and any misuse, wrongful use or any other acts, commissions and omissions of you shall be as per liabilities, duties and obligations under IT Act apart from other terms and conditions mentioned hereinabove and herein below and undertakings and assurances given by you.</ul></ul></ul></ul><ul><ul><ul><ul><ul>You shall not:(i) use the software to run time-sharing or rental or bureau services at any time,(ii) reverse compile or otherwise attempt to arrive at the source code of the software provided by EatPM,(iii) assign, sub-license, license, lease or otherwise alienate, assign, convey retransmit redistribute or transfer the software to any person at any time and shall be strictly used and utilized solely and only for the purposes mentioned in this Terms and conditions, upload any of this software or any other components and modules thereof or EatPM's site information or material to any public server, on-line service, tie up, or other interest in EatPM trademarks, artwork, logo, graphics, application or copyrights by downloading, installing, copying, or otherwise using the software licensed to You.</ul></ul></ul></ul></ul><ul><ul><ul><ul><ul>You assume the entire risk related to your use of this software.</ul></ul></ul></ul></ul></div>";

    private void initializeComponents(final View rootView) {
        ((TextView) rootView
                .findViewById(R.id.id_disclaimer_tv)).setText(Html.fromHtml(TandC_TEXT, null, new UlTagHandler()));
        ((ImageView) rootView.findViewById(R.id.id_disclaimer_close_iv)).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (helpDialog != null) {
                    helpDialog.dismiss();
                }
            }
        });
    }

    public class UlTagHandler implements Html.TagHandler {
        @Override
        public void handleTag(boolean opening, String tag, Editable output,
                              XMLReader xmlReader) {
//            if (tag.equalsIgnoreCase("li")) {
//                if (opening) {
//                    output.append("\u2022");
//                } else {
//                    output.append("\n");
//                }
//            }
        }
    }

}
