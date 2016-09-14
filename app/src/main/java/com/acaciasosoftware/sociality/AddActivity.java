package com.acaciasosoftware.sociality;

import java.sql.Time;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import android.app.Activity;
import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.Toast;
import android.widget.Button;
import android.view.View.OnClickListener;
import android.app.Activity;
import android.content.ContentResolver;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Bitmap;
import android.media.Image;
import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.provider.MediaStore;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

import java.io.File;


public class AddActivity extends ActionBarActivity {
    private Spinner  spinner;
    private Button btnSubmit;
    private static String logtag = "CameraApp8";
    private static int TAKE_PICTURE =1;
    private Uri imageUri;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add);

        // Receiving the Lat and Long
      //  EditText txtLoc = (EditText) findViewById(R.id.edLoc);
     //   Intent i = getIntent();

     //   String LatLong = i.getStringExtra("Lat") + " " +  i.getStringExtra("Long");
      //  txtLoc.setText(LatLong);

        //Get Current Date
      //  Calendar c = Calendar.getInstance();
       // System.out.println("Current time =&gt; "+c.getTime());

       // SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
      //  String formattedDate = df.format(c.getTime());

      //  EditText txtDate = (EditText) findViewById(R.id.edDate);
      //  txtDate.setText(formattedDate);

        addListenerOnButton();
        addListenerOnSpinnerItemSelection();

       // Button cameraButton =(Button)findViewById(R.id.button_camera);
       // cameraButton.setOnClickListener(cameraListener);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_add, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        int id = item.getItemId();

        if (id == R.id.Home) {
            startActivity(new Intent(getApplicationContext(), MapsActivitySoc.class));
            return true;
        }

        if (id == R.id.search) {
            startActivity(new Intent(getApplicationContext(), SearchActivity.class));
            return true;
        }

        if (id == R.id.add) {
            Toast.makeText(getApplicationContext(), "Select a location on the Map to Add entry.", Toast.LENGTH_LONG).show();
            startActivity(new Intent(getApplicationContext(), AddActivity.class));
            return true;
        }

        if (id == R.id.latest) {

            startActivity(new Intent(getApplicationContext(), LatestActivity.class));
            return true;
        }

        if (id == R.id.about) {

            startActivity(new Intent(getApplicationContext(), AboutActivity.class));
            return true;
        }

        if (id == R.id.profile) {
            startActivity(new Intent(getApplicationContext(), ProfileActivity.class));
            return true;
        }

        if (id == R.id.exit) {
            finish();
        }

        return false;
    }

    public void addListenerOnSpinnerItemSelection() {
      //  spinner1 = (Spinner) findViewById(R.id.spinner1);
        spinner.setOnItemSelectedListener(new CustomOnItemSelectedListener());
    }

    // get the selected dropdown list value
    public void addListenerOnButton() {

        spinner = (Spinner) findViewById(R.id.spinner);
        btnSubmit = (Button) findViewById(R.id.btnSubmit);

        btnSubmit.setOnClickListener(new OnClickListener() {

            @Override
            public void onClick(View v) {

                switch (v.getId()) {

                    case R.id.btnSubmit:
                        // do your code
                        Toast.makeText(getApplicationContext(),
                                "OnClickListener : " +
                                        "\nSpinner : "+ String.valueOf(spinner.getSelectedItem()),
                                Toast.LENGTH_SHORT).show();
                        break;

                 //  case R.id.btn:
                   //     // do your code
                        //TODO camera stuff.
//
  //                      break;
                }

            }

        });
    }
    private View.OnClickListener cameraListener = new View.OnClickListener(){
        public void onClick(View v){
            takePhoto(v);
        }
    };

    private void takePhoto(View v) {
        Intent intent = new Intent("android.media.action.IMAGE_CAPTURE");
        File photo = new File(Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_PICTURES), "picture.jpg");
        imageUri = Uri.fromFile(photo);
        intent.putExtra(MediaStore.EXTRA_OUTPUT, imageUri);
        startActivityForResult(intent, TAKE_PICTURE);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent intent){
        super.onActivityResult(requestCode, resultCode, intent);

        if (resultCode == Activity.RESULT_OK)  {
            Uri selectedImage = imageUri;
            getContentResolver().notifyChange(selectedImage, null);

            ImageView imageView = (ImageView)findViewById(R.id.image_Camera);
            ContentResolver cr = getContentResolver();
            Bitmap bitmap;

            try{
                bitmap=MediaStore.Images.Media.getBitmap(cr,selectedImage);
                imageView.setImageBitmap(bitmap);
                Toast.makeText(AddActivity.this, selectedImage.toString(), Toast.LENGTH_LONG).show();
            } catch(Exception e) {
                Log.e(logtag, e.toString());
            }


        }

    }
}


