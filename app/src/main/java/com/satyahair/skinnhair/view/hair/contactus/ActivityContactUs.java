package com.satyahair.skinnhair.view.hair.contactus;

import android.Manifest;
import android.app.Activity;
import android.content.ComponentName;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Matrix;
import android.media.ExifInterface;
import android.net.Uri;
import android.os.Bundle;
import android.os.Parcelable;
import android.provider.MediaStore;
import android.support.design.widget.TextInputLayout;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import com.satyahair.skinnhair.R;
import com.satyahair.skinnhair.apppermission.PermissionActivity;
import com.satyahair.skinnhair.model.bean.BitmapMap;
import com.satyahair.skinnhair.presenter.hair.HairContactUsPresenterImpl;
import com.satyahair.skinnhair.presenter.hair.IHairContactPresenter;
import com.weiwangcn.betterspinner.library.material.MaterialBetterSpinner;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Sandeep on 17/02/2017.
 */

public class ActivityContactUs extends PermissionActivity implements IContactUSView, View.OnFocusChangeListener {
    static final int FRONT_PIC_REQUEST = 1;
    static final int BACK_PIC_REQUEST = 2;
    static final int RIGHT_PIC_REQUEST = 3;
    static final int LEFT_PIC_REQUEST = 4;
    static final int TOP_PIC_REQUEST = 5;
    Button mBtnFrontPic;
    Button mBtnBackPic;
    Button mBtnRightPic;
    Button mBtnLeftPic;
    Button mBtnTopPic;
    ImageView mImgFrontPic;
    ImageView mImgBackPic;
    ImageView mImgRighttPic;
    ImageView mImgLeftPic;
    ImageView mImgTopPic;
    EditText mEdtName;
    EditText mEdtEmail;
    EditText mEdtPhone;
    EditText mEdtMessage;
    TextInputLayout mTextILayoutName;
    TextInputLayout mTextILayoutPhone;
    TextInputLayout mTextILayoutEmail;
    MaterialBetterSpinner mSelectType;
    MaterialBetterSpinner mSelectDoctor;
    MaterialBetterSpinner mSelectSchedule;

    ArrayAdapter<CharSequence> mSelectTypeAdapter;
    ArrayAdapter<CharSequence> mSelectDoctorAdapter;
    ArrayAdapter<CharSequence> mSelectScheduleAdapter;

    BitmapMap mImgFrontPicMap;
    BitmapMap mImgBackPicMap;
    BitmapMap mImgRightPicMap;
    BitmapMap mImgLeftPicMap;
    BitmapMap mImgTopPicMap;


    View mPicLayout;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_contact_us);
        setmToolbar();

        mSelectType = (MaterialBetterSpinner) findViewById(R.id.select_type);
        mSelectDoctor = (MaterialBetterSpinner) findViewById(R.id.select_doctor);
        mSelectSchedule = (MaterialBetterSpinner) findViewById(R.id.select_schedule);
        mEdtEmail = (EditText) findViewById(R.id.edt_email);
        mEdtName = (EditText) findViewById(R.id.edt_usr_name);
        mEdtMessage = (EditText) findViewById(R.id.edt_message);
        mEdtPhone = (EditText) findViewById(R.id.edt_phone);
        mSelectTypeAdapter = ArrayAdapter.createFromResource(this,
                R.array.category, android.R.layout.simple_dropdown_item_1line);

        mSelectDoctorAdapter = ArrayAdapter.createFromResource(this,
                R.array.select_doctor, android.R.layout.simple_dropdown_item_1line);

        mSelectScheduleAdapter = new ArrayAdapter<CharSequence>(this, android.R.layout.simple_dropdown_item_1line);
        mSelectType.setAdapter(mSelectTypeAdapter);
        mSelectDoctor.setAdapter(mSelectDoctorAdapter);
        mSelectSchedule.setAdapter(mSelectScheduleAdapter);
        mSelectType.setText("Appointment");
        setTitle("Book an Appointment");
        mBtnFrontPic = (Button) findViewById(R.id.btn_front_pic);
        mBtnBackPic = (Button) findViewById(R.id.btn_back_pic);
        mBtnRightPic = (Button) findViewById(R.id.btn_right_pic);
        mBtnLeftPic = (Button) findViewById(R.id.btn_left_pic);
        mBtnTopPic = (Button) findViewById(R.id.btn_top_pic);
        mImgFrontPic = (ImageView) findViewById(R.id.txt_front_pic);

        mImgBackPic = (ImageView) findViewById(R.id.txt_back_pic);
        mImgRighttPic = (ImageView) findViewById(R.id.txt_right_pic);
        mImgLeftPic = (ImageView) findViewById(R.id.txt_left_pic);
        mImgTopPic = (ImageView) findViewById(R.id.txt_top_pic);

        mTextILayoutName = (TextInputLayout) findViewById(R.id.textILayout_usr_name);

        mTextILayoutEmail = (TextInputLayout) findViewById(R.id.textILayout_email);

        mTextILayoutPhone = (TextInputLayout) findViewById(R.id.textILayout_phone);
        mPicLayout = findViewById(R.id.pic_layout);

        mTextILayoutName.setOnFocusChangeListener(this);
        mTextILayoutEmail.setOnFocusChangeListener(this);
        mTextILayoutPhone.setOnFocusChangeListener(this);

        mStoragePermissionGranted = getPermission(Manifest.permission.READ_EXTERNAL_STORAGE, 1);
        mBtnFrontPic.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openImageIntent(FRONT_PIC_REQUEST);
            }
        });
        mBtnBackPic.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openImageIntent(BACK_PIC_REQUEST);
            }
        });
        mBtnRightPic.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openImageIntent(RIGHT_PIC_REQUEST);
            }
        });
        mBtnLeftPic.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openImageIntent(LEFT_PIC_REQUEST);
            }
        });
        mBtnTopPic.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openImageIntent(TOP_PIC_REQUEST);
            }
        });

        mSelectDoctor.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                presenter.onDoctorSelected(position);
            }
        });

        mSelectType.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                presenter.onCategorySelected(position);
            }
        });

    }

    protected void openImageIntent(int type) {
        if (!mStoragePermissionGranted) {
            Toast.makeText(this, "Dont have Permission for Storage so can't perform this action", Toast.LENGTH_LONG).show();
            return;
        }
        final List<Intent> cameraIntents = new ArrayList<Intent>();
        final Intent captureIntent = new Intent(android.provider.MediaStore.ACTION_IMAGE_CAPTURE);
        final PackageManager packageManager = getPackageManager();
        final List<ResolveInfo> listCam = packageManager.queryIntentActivities(captureIntent, 0);
        for (ResolveInfo res : listCam) {
            final String packageName = res.activityInfo.packageName;
            final Intent intent = new Intent(captureIntent);
            intent.setComponent(new ComponentName(res.activityInfo.packageName, res.activityInfo.name));
            intent.setPackage(packageName);
            cameraIntents.add(intent);
        }

        final Intent galleryIntent = new Intent();
        galleryIntent.setType("image/*");
        galleryIntent.setAction(Intent.ACTION_PICK);
        final Intent chooserIntent = Intent.createChooser(galleryIntent, "Select Source");
        chooserIntent.putExtra(Intent.EXTRA_INITIAL_INTENTS, cameraIntents.toArray(new Parcelable[cameraIntents.size()]));
        startActivityForResult(chooserIntent, type);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        BitmapMap bitmapMap = new BitmapMap();
        Bitmap bitmap;
        if (resultCode == Activity.RESULT_OK) {
            if (data == null) {
                Toast.makeText(this, "Image not changed. Try again.", Toast.LENGTH_LONG).show();
                return;
            }
            Uri selectedImage = data.getData();
            if (selectedImage == null) {
                bitmap = (Bitmap) data.getExtras().get("data");
                bitmapMap.setBitmap(bitmap);
            } else {
                String[] filePathColumn = {MediaStore.Images.Media.DATA};

                Cursor cursor = getContentResolver().query(selectedImage,
                        filePathColumn, null, null, null);
                cursor.moveToFirst();

                int columnIndex = cursor.getColumnIndex(filePathColumn[0]);
                String picturePath = cursor.getString(columnIndex);
                cursor.close();
                int reqheight = getResources().getDimensionPixelSize(R.dimen.pic_height);
                int reqWidth = getResources().getDimensionPixelSize(R.dimen.pic_width);
                bitmapMap.setPath(picturePath);
                bitmap = decodeSampledBitmapFromFile(picturePath, reqWidth, reqheight);
            }
            try {
                if (bitmapMap.getPath() != null) {
                    bitmap = rotateImageIfRequired(bitmap, bitmapMap.getPath());
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
            if (requestCode == FRONT_PIC_REQUEST) {
                mImgFrontPicMap = bitmapMap;
                mImgFrontPic.setImageBitmap(bitmap);
            } else if (requestCode == BACK_PIC_REQUEST) {
                mImgBackPicMap = bitmapMap;
                mImgBackPic.setImageBitmap(bitmap);
            } else if (requestCode == RIGHT_PIC_REQUEST) {
                mImgRightPicMap = bitmapMap;
                mImgRighttPic.setImageBitmap(bitmap);
            } else if (requestCode == LEFT_PIC_REQUEST) {
                mImgRightPicMap = bitmapMap;
                mImgLeftPic.setImageBitmap(bitmap);
            } else if (requestCode == TOP_PIC_REQUEST) {
                mImgRightPicMap = bitmapMap;
                mImgTopPic.setImageBitmap(bitmap);
                // mUserImage.setImageBitmap(bitmap);
                //GlanceApplicationController.getInstance().saveToInternalStorage(bitmap);
            }
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_submit, menu);
        return true;
    }

    public static Bitmap decodeSampledBitmapFromFile(String filename,
                                                     int reqWidth, int reqHeight) {

        // First decode with inJustDecodeBounds=true to check dimensions
        final BitmapFactory.Options options = new BitmapFactory.Options();
        options.inJustDecodeBounds = true;
        BitmapFactory.decodeFile(filename, options);

        options.inSampleSize = calculateInSampleSize(options, reqWidth, reqHeight);

        options.inJustDecodeBounds = false;
        return BitmapFactory.decodeFile(filename, options);
    }

    IHairContactPresenter presenter = new HairContactUsPresenterImpl(this);

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        switch (item.getItemId()) {
            case R.id.submit:
                presenter.onSubmitClick();
                return true;
            case R.id.cancel:
                presenter.onCancelClick();
                return true;
        }
        return false;
    }

    boolean mStoragePermissionGranted = false;

    @Override
    public void setPermission(int requestCode, boolean isGranted) {
        if (requestCode == 1) {
            if (isGranted) {
                mStoragePermissionGranted = true;
            }
        }
    }

    @Override
    public String getName() {
        return mEdtName.getText().toString();
    }

    @Override
    public String getEmail() {
        return mEdtEmail.getText().toString();
    }

    @Override
    public String getPhone() {
        return mEdtPhone.getText().toString();
    }

    @Override
    public String getMessage() {
        return mEdtMessage.getText().toString();
    }

    @Override
    public BitmapMap getLeftPic() {

        return mImgLeftPicMap;
    }

    @Override
    public BitmapMap getRigthPic() {
        return mImgRightPicMap;
    }

    @Override
    public BitmapMap getFrontPic() {
        return mImgFrontPicMap;
    }

    @Override
    public BitmapMap getBackPic() {
        return mImgBackPicMap;
    }

    @Override
    public BitmapMap getTopPic() {
        return mImgTopPicMap;
    }

    @Override
    public void setNameError(String message) {
        mTextILayoutName.setErrorEnabled(true);
        mTextILayoutName.setError(message);
    }

    @Override
    public void setEmailError(String emailError) {
        mTextILayoutEmail.setError(emailError);
        mTextILayoutEmail.setErrorEnabled(true);
    }

    @Override
    public void setPhoneError(String phoneError) {
        mTextILayoutPhone.setError(phoneError);
        mTextILayoutPhone.setErrorEnabled(true);
    }

    @Override
    public void setSelectDoctorVisiblity(int visiblity) {
        mSelectDoctor.setVisibility(visiblity);
    }

    @Override
    public void setSelectScheduleVisiblity(int visiblity) {
        mSelectSchedule.setVisibility(visiblity);
    }

    @Override
    public void setAdapterForDrRuchi() {
        mSelectScheduleAdapter = ArrayAdapter.createFromResource(this,
                R.array.select_schedule_docor_ruchi, android.R.layout.simple_dropdown_item_1line);
        mSelectSchedule.setAdapter(mSelectScheduleAdapter);
    }

    @Override
    public void setAdapterForDrShail() {
        mSelectScheduleAdapter = ArrayAdapter.createFromResource(this,
                R.array.select_schedule_docor_shail, android.R.layout.simple_dropdown_item_1line);
        mSelectSchedule.setAdapter(mSelectScheduleAdapter);
    }

    @Override
    public String getSelectedDoctor() {
//        return mSelectDoctor.getSele();
        return mSelectDoctor.getText().toString();
    }

    @Override
    public String getSelectedSchedule() {
        return mSelectSchedule.getText().toString();
    }

    @Override
    public String getSelectedCategory() {
        return mSelectType.getText().toString();
    }

    @Override
    public void setScheduleError(String errorMsg) {
        mSelectSchedule.setError(errorMsg);
    }

    @Override
    public void setDoctorSelectError(String errorMsg) {
        mSelectDoctor.setError(errorMsg);
    }

    @Override
    public void clearAll() {
        mTextILayoutName.setErrorEnabled(false);
        mTextILayoutEmail.setErrorEnabled(false);
        mTextILayoutPhone.setErrorEnabled(false);
        mSelectSchedule.setError(null);
//        ((TextView) mSelectDoctor.getSelectedView()).setError(null);
        mEdtEmail.setText("");
        mEdtMessage.setText("");
        mEdtName.setText("");
        mEdtPhone.setText("");
        mImgRighttPic.setImageResource(R.drawable.empty_img);
        mImgFrontPic.setImageResource(R.drawable.empty_img);
        mImgTopPic.setImageResource(R.drawable.empty_img);
        mImgLeftPic.setImageResource(R.drawable.empty_img);
        mImgBackPic.setImageResource(R.drawable.empty_img);
    }

    @Override
    public void uploadingStart() {
        showProgressBar();
    }

    @Override
    public void uploadingEnd() {
        hideProgressBar();
    }

    @Override
    public void showMessage(String message) {
        Toast.makeText(this, message, Toast.LENGTH_LONG).show();
    }

    @Override
    public void updatePicUploadView(int visiblity) {
        mPicLayout.setVisibility(visiblity);
    }


    @Override
    public void onFocusChange(View v, boolean hasFocus) {
        mTextILayoutEmail.setErrorEnabled(false);
        mTextILayoutPhone.setErrorEnabled(false);
        mTextILayoutName.setErrorEnabled(false);
    }

    public static int calculateInSampleSize(BitmapFactory.Options options,
                                            int reqWidth, int reqHeight) {
        // BEGIN_INCLUDE (calculate_sample_size)
        // Raw height and width of image
        final int height = options.outHeight;
        final int width = options.outWidth;
        int inSampleSize = 1;

        if (height > reqHeight || width > reqWidth) {

            final int halfHeight = height / 2;
            final int halfWidth = width / 2;

            // Calculate the largest inSampleSize value that is a power of 2 and keeps both
            // height and width larger than the requested height and width.
            while ((halfHeight / inSampleSize) > reqHeight
                    && (halfWidth / inSampleSize) > reqWidth) {
                inSampleSize *= 2;
            }

            // This offers some additional logic in case the image has a strange
            // aspect ratio. For example, a panorama may have a much larger
            // width than height. In these cases the total pixels might still
            // end up being too large to fit comfortably in memory, so we should
            // be more aggressive with sample down the image (=larger inSampleSize).

            long totalPixels = width * height / inSampleSize;

            // Anything more than 2x the requested pixels we'll sample down further
            final long totalReqPixelsCap = reqWidth * reqHeight * 2;

            while (totalPixels > totalReqPixelsCap) {
                inSampleSize *= 2;
                totalPixels /= 2;
            }
        }
        return inSampleSize;
        // END_INCLUDE (calculate_sample_size)
    }

    private static Bitmap rotateImageIfRequired(Bitmap img, String selectedImage) throws IOException {

        ExifInterface ei = new ExifInterface(selectedImage);
        int orientation = ei.getAttributeInt(ExifInterface.TAG_ORIENTATION, ExifInterface.ORIENTATION_NORMAL);

        switch (orientation) {
            case ExifInterface.ORIENTATION_ROTATE_90:
                return rotateImage(img, 90);
            case ExifInterface.ORIENTATION_ROTATE_180:
                return rotateImage(img, 180);
            case ExifInterface.ORIENTATION_ROTATE_270:
                return rotateImage(img, 270);
            default:
                return img;
        }
    }

    private static Bitmap rotateImage(Bitmap img, int degree) {
        Matrix matrix = new Matrix();
        matrix.postRotate(degree);
        Bitmap rotatedImg = Bitmap.createBitmap(img, 0, 0, img.getWidth(), img.getHeight(), matrix, true);
        img.recycle();
        return rotatedImg;
    }
}
