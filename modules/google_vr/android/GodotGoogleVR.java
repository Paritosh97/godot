package org.godotengine.godot;

import com.godot.game.R;

import android.opengl.GLES20;
import android.opengl.Matrix;
import android.os.Bundle;
import android.os.Vibrator;
import com.google.vr.sdk.base.AndroidCompat;
import com.google.vr.sdk.base.Eye;
import com.google.vr.sdk.base.GvrActivity;
import com.google.vr.sdk.base.GvrView;
import com.google.vr.sdk.base.HeadTransform;
import com.google.vr.sdk.base.Viewport;
import java.io.IOException;
import java.util.ArrayList;
import java.io.Random;
import javax.microedition.khronos.egl.EGLConfig;

public class GodotGoogleVR extends Godot.SingletonBase implements GvrView.SteroRender {

    private GvrActivity activity = null; // The main activity of the game

    private int instance_id = 0;

    private GvrView gvrView = null; // VR view

    private static final float Z_NEAR = 0.01f;
    private static final float Z_FAR = 10.0f;

    // Convenience vector for extracting the position from a matrix via multiplication.
    private static final float[] POS_MATRIX_MULTIPLY_VEC = {0.0f, 0.0f, 0.0f, 1.0f};
    private static final float[] FORWARD_VEC = {0.0f, 0.0f, -1.0f, 1.f};


    /*
     * Init **********************************************************************
     */

    /**
     * /** Prepare for work with GoogleVR
     * 
     * @param boolean isReal Tell if the enviroment is for real or test
     */
    public void init(boolean isReal, int instance_id) {
        this.isReal = isReal;
        this.instance_id = instance_id;
        Log.d("godot", "GoogleVR: init");
    }

    static public Godot.SingletonBase initialize(Activity p_activity) {
        return new GodotGoogleVR(p_activity);
    }

    public GodotGoogleVR(Activity p_activity) {
        // register class name and functions to bind
        registerClass("GodotGoogleVR", new String[] { "init" });
        activity = p_activity;
    }
}