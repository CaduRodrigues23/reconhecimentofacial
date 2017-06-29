package uezo.com.projetoandroid;

import android.content.Context;
import android.hardware.Camera;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.view.ViewGroup.MarginLayoutParams;
import android.widget.LinearLayout;

import static uezo.com.projetoandroid.R.id.top;

public class MainActivity extends AppCompatActivity {
    private Camera mCamera;
    private CameraPreview mPreview;

    private Button btRefresh;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
       setContentView(R.layout.activity_main);

        // Create an instance of Camera
        mCamera = getCameraInstance();

        // Create our Preview view and set it as the content of our activity.
        //mCamera.setFaceDetectionListener(new MyFaceDetectionListener());
        mPreview = new CameraPreview(this, mCamera);
        FrameLayout preview = (FrameLayout) findViewById(R.id.visor_camera);
        preview.addView(mPreview);


        btRefresh = (Button) findViewById(R.id.btRefresh);

        btRefresh.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ImageView desenho = (ImageView) findViewById(R.id.tela_desenho);
                desenho.setPadding(CameraPreview.x, CameraPreview.y, 0, 0);
            }
        });

        ImageView desenho = (ImageView) findViewById(R.id.tela_desenho);
        desenho.setPadding(0, 0,  0, 0);

    }



    public static Camera getCameraInstance(){
        Camera c = null;
        try {
            c = Camera.open(); // attempt to get a Camera instance
        }
        catch (Exception e){
            // Camera is not available (in use or does not exist)
        }
        return c; // returns null if camera is unavailable
    }

    public void AtualizarPosicao() {
        ImageView desenho = (ImageView) findViewById(R.id.tela_desenho);
        desenho.setPadding(CameraPreview.x, CameraPreview.y, 0, 0);
    }

}
