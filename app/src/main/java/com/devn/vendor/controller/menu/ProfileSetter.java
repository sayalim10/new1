package com.devn.vendor.controller.menu;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.ActivityNotFoundException;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.graphics.Rect;
import android.graphics.RectF;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.util.Base64;
import android.widget.TextView;
import android.widget.Toast;

import static com.devn.vendor.screens.home.HomeScreenDrawer.PROFILE_ID;
import static com.devn.vendor.utils.ImageCompressor.IMAGE_QUALITY;
import static com.devn.vendor.utils.ImageCompressor.compress;

import com.devn.vendor.utils.ImageCompressor;
import com.devn.vendor.utils.V;
import com.mikepenz.materialdrawer.AccountHeader;
import com.mikepenz.materialdrawer.Drawer;
import com.mikepenz.materialdrawer.model.ProfileDrawerItem;
import com.mikepenz.materialdrawer.model.interfaces.IProfile;

import java.io.ByteArrayOutputStream;

import static android.app.Activity.RESULT_OK;

/**
 * Created by Nitin.Kalokhe on 29-06-2017.
 */

public class ProfileSetter {
    public static final int CAMERA_CAPTURE = 1;
    public static final int SELECT_FILE = 3;

    private Context mContext;
    private Drawer mDrawer;
    private static String USER_NAME_DB = "profile_pic";
    private String USER_ID = "";
    private AccountHeader accountHeader;
    private IProfile mProfile;

    public void setAccountHeader(AccountHeader accountHeader) {
        this.accountHeader = accountHeader;
    }

    public void setDrawer(Drawer drawer) {
        this.mDrawer = drawer;
    }

    public ProfileSetter(Context context) {
        this.mContext = context;
    }

    public void set(IProfile profile) {
        this.mProfile = profile;
        if (!V.isEmpty("N3@Programmer")) {
            USER_NAME_DB = "N3@Programmer";
        }
        USER_ID = "N3@Programmer";

        selectImage();
    }


    private void selectImage() {
        final CharSequence[] items = {"Take Photo", "Choose from Gallery", "Cancel"};
        AlertDialog.Builder builder = new AlertDialog.Builder(mContext);
        builder.setTitle("Add Profile Picture !");
        builder.setItems(items, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int item) {
                if (items[item].equals(items[0])) {
                    openCamera();
                } else if (items[item].equals(items[1])) {
                    Intent intent = new Intent();
                    intent.setType("image/*");
                    intent.setAction(Intent.ACTION_GET_CONTENT);
                    ((Activity) mContext).startActivityForResult(Intent.createChooser(intent, "Select Image"), SELECT_FILE);
                } else if (items[item].equals(items[2])) {
                    dialog.dismiss();
                }
            }
        });
        builder.show();
    }

    //    @AskPermission(Manifest.permission.CAMERA)
    private void openCamera() {
        try {
            Intent captureIntent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
            ((Activity) mContext).startActivityForResult(captureIntent, CAMERA_CAPTURE);
        } catch (ActivityNotFoundException anfe) {
            Toast.makeText(mContext, "This device doesn't support the crop action!", Toast.LENGTH_SHORT).show();
        }

    }


    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        try {
            if (resultCode == RESULT_OK) {
                if (requestCode == CAMERA_CAPTURE) {
                    Bundle extras = data.getExtras();
                    Bitmap pic_camera = extras.getParcelable("data");
                    if (pic_camera != null) {

                        pic_camera = getRoundedBitmapnow(pic_camera, null);
                        setNewProfilePic(pic_camera);
                        saveToDatabase(pic_camera);
                    }
                } else if (requestCode == SELECT_FILE) {
                    if (data != null) {
                        try {
                            Bitmap pic_camera = getRoundedBitmapnow(null, data.getData());
                            setNewProfilePic(pic_camera);
                            saveToDatabase(pic_camera);
//                            }
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                    }
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void setNewProfilePic(Bitmap pic_camera) {
        ProfileDrawerItem mProfile = new ProfileDrawerItem().withName("" + USER_NAME_DB).withEmail("" + USER_ID).withIcon(pic_camera).withIdentifier(PROFILE_ID);
        accountHeader.updateProfile(mProfile);
        mDrawer.getAdapter().notifyAdapterDataSetChanged();
    }


    private void saveToDatabase(Bitmap pic_camera) {
        try {
            SharedPreferences sharedPreferences = mContext.getSharedPreferences("profile_image", mContext.MODE_PRIVATE);
            SharedPreferences.Editor edit = sharedPreferences.edit();
            edit.putString("profile_pic", encodeToBase64(pic_camera));
            edit.commit();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    public static Bitmap getProfilePic(Context context) {
        SharedPreferences sharedPreferences = context.getSharedPreferences("profile_image", context.MODE_PRIVATE);
        String imagepath = sharedPreferences.getString("profile_pic", "");
        if (!(imagepath.equals(""))) {
            Bitmap bitmap = decodeToBase64(imagepath);
            return bitmap;
        }
        return null;
    }

    private static Bitmap decodeToBase64(String input) {
        byte[] decodedByte = Base64.decode(input, 0);
        return BitmapFactory.decodeByteArray(decodedByte, 0, decodedByte.length);
    }

    private String encodeToBase64(Bitmap image) {
        Bitmap immage = image;
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        immage.compress(Bitmap.CompressFormat.PNG, IMAGE_QUALITY, baos);
        byte[] b = baos.toByteArray();
        String imageEncoded = Base64.encodeToString(b, Base64.DEFAULT);
        return imageEncoded;
    }

    private Bitmap getRoundedBitmapnow(Bitmap bitmap, Uri imgUri) {
        Bitmap dstBmp = null, output = null;
        try {
            int tempWidth = ImageCompressor.REQ_WIDTH;
            int tempHeight = ImageCompressor.REQ_HEIGHT;
            ImageCompressor.REQ_WIDTH = 200;
            ImageCompressor.REQ_HEIGHT = 200;
            bitmap = compress(mContext, bitmap, imgUri);
            ImageCompressor.REQ_WIDTH = tempWidth;
            ImageCompressor.REQ_HEIGHT = tempHeight;

            if (bitmap.getWidth() >= bitmap.getHeight()) {

                dstBmp = Bitmap.createBitmap(
                        bitmap,
                        bitmap.getWidth() / 2 - bitmap.getHeight() / 2,
                        0,
                        bitmap.getHeight(),
                        bitmap.getHeight()
                );

            } else {
                dstBmp = Bitmap.createBitmap(bitmap, 0, bitmap.getHeight() / 2 - bitmap.getWidth() / 2, bitmap.getWidth(), bitmap.getWidth()
                );
            }
            //          create circle
            output = Bitmap.createBitmap(dstBmp.getWidth(), dstBmp.getHeight(), Bitmap.Config.ARGB_8888);
            Canvas canvas = new Canvas(output);
            final int color = 0xff424242;
            final Paint paint = new Paint();
            final Rect rect1 = new Rect(0, 0, dstBmp.getWidth(), dstBmp.getHeight());
            final RectF rectF1 = new RectF(rect1);
            paint.setAntiAlias(true);
            canvas.drawARGB(0, 0, 0, 0);
            paint.setColor(color);
            canvas.drawOval(rectF1, paint);
            paint.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.SRC_IN));
            canvas.drawBitmap(dstBmp, rect1, rect1, paint);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return output;
    }

}
