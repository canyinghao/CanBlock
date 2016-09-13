package com.canyinghao.canblock.demo;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Environment;
import android.provider.MediaStore;
import android.util.DisplayMetrics;
import android.view.Display;
import android.view.View;
import android.view.WindowManager;

import com.canyinghao.canblock.CanBlock;

import java.io.File;
import java.util.ArrayList;

/**
 * 获取本地剪切后的图片
 */
public class CutImgHelper extends CanBlock {


    private final int FROM_CAMERA = 0;
    private final int FROM_PHOTO = 1;
    private final int FROM_CUT = 2;


    private int cutW;
    private int cutH;
    private int fromid;

    public static final String FILE_IMG = "temp";
    public static final String TAG = "CutImgHelper";


    private File saveFile;

    private boolean isCrop;

    @Override
    public void initView() {
        View v = new View(mContext);
        setContentView(v);

        v.setVisibility(View.GONE);

        cutW = getScreenDisplayMetrics().widthPixels;
        cutH = cutW / 2;


    }

    @Override
    public void initListener() {

    }

    @Override
    public void initData() {

    }

    public CutImgHelper() {
        super();
    }

    public CutImgHelper(int fromid) {
        super();
        this.fromid = fromid;
    }

    public void setWHsize(int cutW, int cutH) {
        this.cutW = cutW;
        this.cutH = cutH;
    }


    // 选择图片来源
    public void showOptionsDialog(final boolean isCrop) {

        this.isCrop = isCrop;

        saveFile = new File(getActivity().getExternalCacheDir(), FILE_IMG + System.currentTimeMillis() + ".jpg");

        String[] items = new String[]{"拍照", "选择本地图片"};

        DialogInterface.OnClickListener click = new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                switch (which) {
                    case 0:// 拍照

                        if (Environment.getExternalStorageState().equals(
                                Environment.MEDIA_MOUNTED)) {
                            Intent intentFromCapture = new Intent(
                                    MediaStore.ACTION_IMAGE_CAPTURE);
                            intentFromCapture.putExtra(MediaStore.EXTRA_OUTPUT, Uri
                                    .fromFile(saveFile));
                            getActivity().startActivityForResult(intentFromCapture, FROM_CAMERA);
                        }
                        break;
                    case 1:// 选择本地图片


                        if (isCrop) {
//							AlbumUtil.gotoCrop(getActivity(), false);
//						Intent intentFromGallery = new Intent();
//						intentFromGallery.setType("image/*"); // 设置文件类型
//						intentFromGallery.setAction(Intent.ACTION_GET_CONTENT);
//						getActivity().startActivityForResult(intentFromGallery, FROM_PHOTO);
                            Intent picture = new Intent(
                                    Intent.ACTION_PICK,
                                    MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
                            getActivity().startActivityForResult(picture, FROM_PHOTO);
                        } else {
//							AlbumUtil.gotoAlbum(getActivity(),null,5);
                        }


                        break;
                }
            }
        };

        new AlertDialog.Builder(mContext).setItems(items, click).show()
                .setCanceledOnTouchOutside(true);
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {

        super.onActivityResult(requestCode, resultCode, data);
        if (resultCode == Activity.RESULT_OK) {
            switch (requestCode) {
                case FROM_CAMERA:

                    if (isCrop) {

                        startPhotoZoom(Uri.fromFile(saveFile));
                    } else {
                        ArrayList<String> list = new ArrayList<>();
                        list.add(saveFile.getAbsolutePath());
//						CanBus.getDefault().post(list,CanBus.CANBUS_IMG);
                    }


                    break;
                case FROM_PHOTO:
                    if (data != null) {
                        if (data == null) {
//							PhoneHelper.getInstance().show("抱歉无法获取到该手机相册权限，请拍照上传");
                            return;
                        }
                        try {
                            Uri selectedImage = data.getData();
                            String[] filePathColumns = {MediaStore.Images.Media.DATA};
                            Cursor c = mContext.getContentResolver().query(selectedImage, filePathColumns, null, null, null);
                            c.moveToFirst();
                            int columnIndex = c.getColumnIndex(filePathColumns[0]);
                            String picturePath = c.getString(columnIndex);
                            if (!picturePath.contains("file://")) {
                                picturePath = "file://" + picturePath;
                            }
                            startPhotoZoom(Uri.parse(picturePath));
                        } catch (Exception e) {
                            String file = data.getData().toString();
                            if (!file.contains("file://")) {
                                file = "file://" + file;
                            }
                            startPhotoZoom(Uri.parse(file));
                        }
                    }
                    break;
                case FROM_CUT:
                    if (data != null) {
                        savePhoto();

                    }
                    break;
//				case AlbumUtil.REQUEST_CODE_SEND_PICTURE:
//					if (data!=null){
//
//						ArrayList<String>   list= data.getStringArrayListExtra(AlbumUtil.DRR);
//						CanBus.getDefault().post(list,CanBus.CANBUS_IMG);
//
//					}
//
//
//
//					break;
                default:
                    break;
            }
        }
    }


    private void savePhoto() {


        if (saveFile.exists()) {

//				Intent intent = new Intent();
//				intent.putExtra(Constants.bean,saveFile.getAbsolutePath());
//				intent.putExtra(Constants.CUT_IMAGE_FROM_ID,fromid);
//				CanBus.getDefault().post(intent, CanBus.CANBUS_CROP_RESULT);
//				Toast.makeText(mContext, "save", Toast.LENGTH_SHORT).show();


        }


    }


    /**
     * 裁剪图片方法实现
     */
    private void startPhotoZoom(Uri uri) {

        Intent intent = new Intent("com.android.camera.action.CROP");
        intent.setDataAndType(uri, "image/*");
        intent.putExtra("crop", "true");
        intent.putExtra("aspectX", cutW);
        intent.putExtra("aspectY", cutH);
        intent.putExtra("outputX", cutW);
        intent.putExtra("outputY", cutH);
        intent.putExtra("noFaceDetection", true);
        intent.putExtra("scale", true);
        intent.putExtra("scaleUpIfNeeded", true);
        intent.putExtra("return-data", false);
        intent.putExtra(MediaStore.EXTRA_OUTPUT, Uri.fromFile(saveFile));
        intent.putExtra("outputFormat", Bitmap.CompressFormat.JPEG.toString());


        getActivity().startActivityForResult(intent, FROM_CUT);
    }


    public DisplayMetrics getScreenDisplayMetrics() {
        WindowManager manager = (WindowManager) mContext
                .getSystemService(mContext.WINDOW_SERVICE);

        DisplayMetrics displayMetrics = new DisplayMetrics();
        Display display = manager.getDefaultDisplay();
        display.getMetrics(displayMetrics);

        return displayMetrics;

    }
}
