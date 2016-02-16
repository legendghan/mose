package com.legendhan.mose;

import android.annotation.*;
import android.app.*;
import android.content.*;
import android.content.res.*;
import android.graphics.*;
import android.net.*;
import android.os.*;
import android.provider.*;
import android.view.*;
import android.view.View.*;
import android.widget.*;
import android.widget.AdapterView.*;
import java.io.*;
import java.lang.reflect.*;
import java.util.*;
import java.util.zip.*;

import android.view.View.OnClickListener;

public class MainActivity extends Activity {
   
	@Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
            filepath=Environment.getExternalStorageDirectory().getPath()+"/mose/";
    		File file = new File(filepath);
    		if (!file.exists()) {
    		file.mkdir();
    		}
            picpath=Environment.getExternalStorageDirectory().getPath()+"/mose/pic/";
            file = new File(picpath);
    		if (!file.exists()) {
    		file.mkdir();
    		}
            setpath=Environment.getExternalStorageDirectory().getPath()+"/mose/temp/";
            file = new File(setpath);
            if (!file.exists()) {
    		file.mkdir();
    		}else{
    			if(new File(setpath+"set").exists()){
    				if(readSet(new File(setpath+"set"))){
    					file.delete();
    					file.mkdir();
    				}
    			}
    			
    		}
            scriptpath=Environment.getExternalStorageDirectory().getPath()+"/mose/script/";
            file = new File(scriptpath);
    		if (!file.exists()) {
    		file.mkdir();
    		}
    		getOverflowMenu();
    		
 /*     	Display canvas=this.getWindowManager().getDefaultDisplay();
 //   		canva
 //   		int plustop = getWindow().findViewById(Window.ID_ANDROID_CONTENT).getTop();
    		hei=canvas.getHeight();wid=canvas.getWidth();
    		 if(wid-hei*0.68>0){
    		    	top=0;
    		    	bottom=hei;
    		    	left=(float) (0.5*(wid-hei*0.68));
    		    	right=(float) (wid-2*left);
    		    	}
    		    else{
    		    	left=0;
    		    	right=wid;
    		    	top=(float) (0.5*(hei-wid/0.68));
    		    	bottom=(float) (hei-2*top);
    		    	}
    		 height=hei-2*top;width=wid-2*left;*/
        	refresh(this);
        	dataopreate();
        	final ActionBar acb=this.getActionBar();
        	acb.hide();
        	setContentView(R.layout.start);
        	Button orm=(Button) findViewById(R.id.button2)
				,ex=(Button) findViewById(R.id.button3);
        	orm.setOnClickListener(new OnClickListener(){
        		
        		@Override
        		public void onClick(View v) {
        		    acb.show();
        			MainActivity.refresh(MainActivity.this);
        		}
        	});
        	ex.setOnClickListener(new OnClickListener(){
        		
        		@Override
        		public void onClick(View v) {
        			finish();
        		}
        	});
        }

	
 private void getOverflowMenu() {
	         try {
	            ViewConfiguration config = ViewConfiguration.get(this);
	            Field menuKeyField = ViewConfiguration.class.getDeclaredField("sHasPermanentMenuKey");
	            if(menuKeyField != null) {
	                 menuKeyField.setAccessible(true);
	                 menuKeyField.setBoolean(config, false);
	            }
	        } catch (Exception e) {
	        }
	    }
    @Override
    public boolean onPrepareOptionsMenu(Menu menu) {
    	menu.clear();
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.main, menu);
        
        MenuItem menuItem = menu.findItem(R.id.pword);
        if (!is_p) {
            menuItem.setVisible(false);
        }
        MenuItem menuItem1 = menu.findItem(R.id.stlv);
        if (is_mt) {
            menuItem1.setVisible(false);
        }
        MenuItem menuItem2 = menu.findItem(R.id.shx);
        if (is_mt) {
            menuItem2.setVisible(false);
        }
        MenuItem menuItem3 = menu.findItem(R.id.mgtp);
        if (is_mt & kamoselect!=16) {
            menuItem3.setVisible(true);
        }
        MenuItem menuItem4 = menu.findItem(R.id.atkd);
        if (is_mt) {
            menuItem4.setVisible(false);
        }
        return true;
    }
    
    public static int openfileDialogId = 0,end=0,kamoselect=1,shuxselect=1,level=0,mttype=1,leng=1,sepmount=1,cardmount=0,kmhg=0,kthg=0,khg=0,bkhg=0,fwhg=0;;
    public static String str1="輸入卡名！",str2="种族/种類",xg="使用菜單輸入效果或描述文字，注意符號不能放在每一行末尾。效果越線請添加空格縮小字號。"
    		,atk="0",def="0",mt_type="",pendxg=" ",pendkd="0",kbbh="MOSE-TC001",kpmm="00000000",bq="©高橋和希 スタヅオ·ダイス/集英社",picpath="",filepath="",setpath="",
    		readpath="",scriptpath="",zhongz="种族",zlei1="种类",zlei2="",zlei3="",cardscript="",filetype="";
    public static boolean bigp=false,katuout=false,is_mt=false,is_p=false,TEMP_DELETE_FLAG=false;
    		//,legendhan=true;
    public static Bitmap kt;

   
    protected static float hei=0,wid=0,left,top,right,bottom,height,width,left4,top4,right4,bottom4,left1,top1,right1,bottom1,
			le,tp,left3,top3,right3,bottom3,left3s,left3b,right3s,right3b,top3s,top3b,
			bottom3s,bottom3b,left2,top2,right2,right2x,bottom2,l,r,t,b
			,left2x,top2p,bottom2p;
	public static RectF rectkm,rect1,rect2,rect2p,rect3,rect3s,rect3b,rectkthg,rect4,rectfw,rect2x;
	
	public void dataopreate(){
		Display canvas=this.getWindowManager().getDefaultDisplay();
		Class<?> c = null;
		Object obj = null;
		Field field = null;
		int x = 0, sbar = 0;
		try {
			c = Class.forName("com.android.internal.R$dimen");
			obj = c.newInstance();
			field = c.getField("status_bar_height");
			x = Integer.parseInt(field.get(obj).toString());
			sbar = getResources().getDimensionPixelSize(x);
		} catch(Exception e1) {
			e1.printStackTrace();
		}
	    TypedArray actionbarSizeTypedArray = obtainStyledAttributes(new int[] {
                android.R.attr.actionBarSize
        });

        float h = actionbarSizeTypedArray.getDimension(0, 0);
		
		hei=canvas.getHeight()-h-sbar;
		wid=canvas.getWidth();
		if(wid-hei*0.68>0){
		 top=0;
		 bottom=hei;
		 left=(float) (0.5*(wid-hei*0.68));
		 right=(float) (wid-2*left);
	    	}
	    else{
	    	left=0;
	    	right=wid;
	    	top=(float) (0.5*(hei-wid/0.68));
	    	bottom=(float) (hei-2*top);
	    	}
	height=hei-2*top;
	width=wid-2*left;
    left1=(float) (0.845*width);
    top1=(float) (0.0488*height);
    right1=(float) (0.933*width);
    bottom1=(float) (top1+right1-left1);
    
    l=(float) (0.925*width);
    t=(float) (0.95*height);
    r=(float) (0.965*width);
    b=(float) (t+r-l);
    
    left4=(float) (0.825*width);
    top4=(float)(0.126*height);
    right4=(float) (left4+0.05*width);
    bottom4=(float) (top4+right4-left4);
	
	left2x=(float)(0.104*width);
	left2=(float)(0.84*width);
    top2p=(float) (0.125*height);
    bottom2p=(float) (0.166*height);
	top2=(float) (0.122*height);
	bottom2=(float) (0.163*height);
    right2=(float) (left2+bottom2-top2);
    right2x=(float) (left2x+bottom2-top2);
    
	top3=(float)(0.180*height);
	bottom3=(float) (top3+0.53*height);
    left3=(float) (0.112*width);
    left3b=(float) (0.064*width);
    top3b=(float)(0.178*height);
    bottom3b=(float) (top3+0.45*height);
    left3s=(float) (0.064*width);
    top3s=(float)(0.178*height);
    bottom3s=(float) (top3+0.485*height);
	right3=(float) (width-left3);
	right3b=(float) (width-left3b);
	right3s=(float) (width-left3s);
	
	}

    private void ShowPickDialog() {
    	new AlertDialog.Builder(this)
    	.setTitle("设置图片...")
    	.setNegativeButton("相册", new DialogInterface.OnClickListener() {
    	public void onClick(DialogInterface dialog, int which) {
    	dialog.dismiss();
    	Intent intent = new Intent(Intent.ACTION_PICK, null);
    	intent.setDataAndType(
    	MediaStore.Images.Media.EXTERNAL_CONTENT_URI,
    	"image/*");
    	startActivityForResult(intent, 1);
    	}
    	})
    	.setPositiveButton("拍照", new DialogInterface.OnClickListener() {
    	public void onClick(DialogInterface dialog, int whichButton) {
    	dialog.dismiss();
    	Intent intent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
    	intent.putExtra(MediaStore.EXTRA_OUTPUT, imageUri);
    	startActivityForResult(intent, 2);
    	}
    	}).show();
    	}

    @SuppressLint("SdCardPath")
	Uri imageUri = Uri.parse("file:///sdcard/mose/temp/image");
    
    private Bitmap decodeUriAsBitmap(Uri uri){
    	 Bitmap bitmap = null;
    	 try {
    	  bitmap = BitmapFactory.decodeStream(getContentResolver().openInputStream(uri));
    	 } catch (FileNotFoundException e) {
    	  e.printStackTrace();
    	  return null;
    	 }
    	 return bitmap;
    	}
         private void cropImageUri(Uri uri){
    	 Intent intent = new Intent("com.android.camera.action.CROP");
    	 intent.setDataAndType(uri, "image/*");
    	 intent.putExtra("crop", "true");
    	 intent.putExtra("scale", true);
    	 intent.putExtra("scaleUpIfNeeded", true);
    	 intent.putExtra("scale", true);
    	 intent.putExtra(MediaStore.EXTRA_OUTPUT, uri);
    	 intent.putExtra("return-data", false);
    	 intent.putExtra("outputFormat", Bitmap.CompressFormat.JPEG.toString());
    	 intent.putExtra("noFaceDetection", true);
    	 startActivityForResult(intent, 3);
    	}
    	@Override
    	protected void onActivityResult(int requestCode, int resultCode, Intent data) {
    	switch (requestCode) {
    	case 1:
    	startPhotoZoom(data.getData());
    	break;
    	case 2:
    		cropImageUri(imageUri);
    	break;
    	case 3:
    		 if(imageUri != null){
    			  kt = decodeUriAsBitmap(imageUri);
    			  kt = Bitmap.createScaledBitmap(kt, 600, 600, true);
    	          setContentView(new KaMo(this));
    			 }
    			 break;
    	default:
    	break;
    	}
    	super.onActivityResult(requestCode, resultCode, data);
    	}
    	public void startPhotoZoom(Uri uri) {
    	Intent intent = new Intent("com.android.camera.action.CROP");
    	intent.setDataAndType(uri, "image/*");
    	intent.putExtra("crop", "true");
    	intent.putExtra("scale", true);
   	 	intent.putExtra("scaleUpIfNeeded", true);
    	intent.putExtra("return-data",  false);
    	intent.putExtra(MediaStore.EXTRA_OUTPUT, imageUri);
    	intent.putExtra("outputFormat", Bitmap.CompressFormat.JPEG.toString());
    	intent.putExtra("noFaceDetection", true);
    	startActivityForResult(intent, 3);
    	}
    
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
        case R.id.nm:
            kamoselect=1;
            is_mt=false;
            setContentView(new KaMo(this));
    break;
        case R.id.em:
            kamoselect=2;
            is_mt=false;
            setContentView(new KaMo(this));
    break;
        case R.id.rm:
            kamoselect=3;
            is_mt=false;
            setContentView(new KaMo(this));
    break;
        case R.id.fm:
            kamoselect=4;
            is_mt=false;
            setContentView(new KaMo(this));
    break;
        case R.id.sm:
            kamoselect=5;
            is_mt=false;
            setContentView(new KaMo(this));
    break;
        case R.id.xm:
            kamoselect=6;
            is_mt=false;
            setContentView(new KaMo(this));
    break;
        case R.id.mg:
            kamoselect=9;
            is_mt=true;
            if(is_p){is_p=false;
            setContentView(new KaMo(this));}
            else{setContentView(new KaMo(this));}
    break;
        case R.id.trp:
            kamoselect=11;
            is_mt=true;
            if(is_p){is_p=false;
            setContentView(new KaMo(this));}
            else{setContentView(new KaMo(this));}
    break;
        case R.id.tk:
            kamoselect=12;
            is_mt=false;
            if(is_p){is_p=false;
            setContentView(new KaMo(this));}
            else{setContentView(new KaMo(this));}
    break;
        case R.id.bltk:
            kamoselect=16;
            is_mt=true;
            if(is_p){is_p=false;
            setContentView(new KaMo(this));}
            else{setContentView(new KaMo(this));}
    break;
        case R.id.pmode:
        	if(is_p){
            is_p=false;
            setContentView(new KaMo(this));}
            else{
        	if(kamoselect < 8){
            is_p=true;
            	if(pendxg.length()>108){bigp=true;}
            setContentView(new KaMo(this));
            }
        	else{
                Toast.makeText(getApplicationContext(),"灵摆无法摆动！",Toast.LENGTH_SHORT).show();
        	}}
    break;
    
        case R.id.lv12:
            level=1;
            setContentView(new KaMo(this));
    break;
        case R.id.lv11:
            level=2;
            setContentView(new KaMo(this));
    break;
        case R.id.lv10:
            level=3;
            setContentView(new KaMo(this));
    break;
        case R.id.lv9:
            level=4;
            setContentView(new KaMo(this));
    break;
        case R.id.lv8:
            level=5;
            setContentView(new KaMo(this));
    break;
        case R.id.lv7:
            level=6;
            setContentView(new KaMo(this));
    break;
        case R.id.lv6:
            level=7;
            setContentView(new KaMo(this));
    break;
        case R.id.lv5:
            level=8;
            setContentView(new KaMo(this));
    break;
        case R.id.lv4:
            level=9;
            setContentView(new KaMo(this));
    break;
        case R.id.lv3:
            level=10;
            setContentView(new KaMo(this));
    break;
        case R.id.lv2:
            level=11;
            setContentView(new KaMo(this));
    break;
        case R.id.lv1:
            level=12;
            setContentView(new KaMo(this));
    break;
        case R.id.lv0:
            level=0;
            setContentView(new KaMo(this));
    break;
        case R.id.pkedu:
            final EditText inputServ = new EditText(this);
            inputServ.setText(pendkd);
            AlertDialog.Builder build = new AlertDialog.Builder(this);
            build.setTitle("灵摆刻度").setIcon(android.R.drawable.ic_dialog_info).setView(inputServ)
                    .setNegativeButton("取消", null);
            build.setPositiveButton("确定", new DialogInterface.OnClickListener() {

                public void onClick(DialogInterface dialog, int which) {
                	pendkd=inputServ.getText().toString();

                    setContentView(new KaMo(MainActivity.this));
                 }
            });
            build.show();
    break;
        case R.id.peffect:
            final EditText inputServe = new EditText(this);
            inputServe.setText(pendxg);
            AlertDialog.Builder builde = new AlertDialog.Builder(this);
            builde.setTitle("灵摆效果").setIcon(android.R.drawable.ic_dialog_info).setView(inputServe)
                    .setNegativeButton("取消", null);
            builde.setPositiveButton("确定", new DialogInterface.OnClickListener() {

                public void onClick(DialogInterface dialog, int which) {
                	pendxg=trans(inputServe.getText().toString());

               		pendxg=pendxg.replaceFirst("\n","0xDEADBEEF").replaceAll("\n","").replaceFirst("0xDEADBEEF","\n").replaceAll(";","；").replaceAll(":","：").replaceAll(",","，").replaceAll("1","１").replaceAll("2","２").replaceAll("3","３").replaceAll("4","４").replaceAll("5","５").replaceAll("6","６").replaceAll("7","７").replaceAll("8","８").replaceAll("9","９").replaceAll("0","０").replaceAll("【","「").replaceAll("】","」");
               		
               		if(pendxg.length()>108){bigp=true;}else{bigp=false;}
               		
                    setContentView(new KaMo(MainActivity.this));
                 }
            });
            builde.show();
    break;
        case R.id.shxl:
            shuxselect=1;
            setContentView(new KaMo(this));	
    break;
        case R.id.shxd:
            shuxselect=7;
            setContentView(new KaMo(this));
    break;
        case R.id.shxf:
            shuxselect=5;
            setContentView(new KaMo(this));
    break;
        case R.id.shxwd:
            shuxselect=3;
            setContentView(new KaMo(this));
    break;
        case R.id.shxw:
            shuxselect=4;
            setContentView(new KaMo(this));
    break;
        case R.id.shxg:
            shuxselect=2;
            setContentView(new KaMo(this));
    break;
        case R.id.shxgd:
            shuxselect=6;
            setContentView(new KaMo(this));
    break;
        case R.id.ttkm:
            final EditText inputServer = new EditText(this);
            inputServer.setText(str1);
            AlertDialog.Builder builder = new AlertDialog.Builder(this);
            builder.setTitle("卡名").setIcon(android.R.drawable.ic_dialog_info).setView(inputServer)
                    .setNegativeButton("取消", null);
            builder.setPositiveButton("确定", new DialogInterface.OnClickListener() {

                public void onClick(DialogInterface dialog, int which) {
                	str1=trans(inputServer.getText().toString());
                    setContentView(new KaMo(MainActivity.this));
                 }
            });
            builder.show();
    break;
        case R.id.ttzz:
        	LayoutInflater factory=LayoutInflater.from(MainActivity.this);
        	final View myView=factory.inflate(R.layout.diolog,null);
        	final EditText zz=(EditText)myView.findViewById(R.id.zz);
        	final EditText zl1=(EditText)myView.findViewById(R.id.zl1);
        	final EditText zl2=(EditText)myView.findViewById(R.id.zl2);
        	final EditText zl3=(EditText)myView.findViewById(R.id.zl3);
	      	zz.setText(zhongz);
        	zl1.setText(zlei1);
        	zl2.setText(zlei2);
        	zl3.setText(zlei3);
    		AlertDialog.Builder dialog=new AlertDialog.Builder(this);
        	dialog.setView(myView)
        	.setTitle("种族/种类").setNegativeButton("取消",null);
        	dialog.setPositiveButton("确定", new DialogInterface.OnClickListener() {
        	public void onClick(DialogInterface dialog, int which) {
        		zhongz=trans(zz.getText().toString());
        		zlei1=trans(zl1.getText().toString());
        		zlei2=trans(zl2.getText().toString());
        		zlei3=trans(zl3.getText().toString());
        		if(zlei3.equals("")==false){str2=zhongz+"/"+zlei1+"/"+zlei2+"/"+zlei3;}
        		else{if(zlei2.equals("")==false){str2=zhongz+"/"+zlei1+"/"+zlei2;}
        		else{if(zlei1.equals("")==false){str2=zhongz+"/"+zlei1;}
        		else{str2=zhongz;}}}
                setContentView(new KaMo(MainActivity.this));
        	}
        	});
        	dialog.show();
    break;
        case R.id.ttxg:
            final EditText inputServer11 = new EditText(this);
            inputServer11.setText(xg);
            AlertDialog.Builder builder11 = new AlertDialog.Builder(this);
            builder11.setTitle("效果").setIcon(android.R.drawable.ic_dialog_info).setView(inputServer11)
                    .setNegativeButton("取消", null);
            builder11.setPositiveButton("确定", new DialogInterface.OnClickListener() {

                public void onClick(DialogInterface dialog, int which) {
                   xg=trans(inputServer11.getText().toString());

           		xg=xg.replaceFirst("\n","0xDEADBEEF").replaceAll("\n","").replaceFirst("0xDEADBEEF","\n").replaceAll(";","；").replaceAll(":","：").replaceAll(",","，").replaceAll("1","１").replaceAll("2","２").replaceAll("3","３").replaceAll("4","４").replaceAll("5","５").replaceAll("6","６").replaceAll("7","７").replaceAll("8","８").replaceAll("9","９").replaceAll("0","０").replaceAll("【","「").replaceAll("】","」");
                   setContentView(new KaMo(MainActivity.this));
                 }
            });
            builder11.show();
    break;
        case R.id.atkd:
        	LayoutInflater factor=LayoutInflater.from(MainActivity.this);
        	final View adView=factor.inflate(R.layout.atdelog,null);
        	final EditText atak=(EditText)adView.findViewById(R.id.atak);
        	final EditText defe=(EditText)adView.findViewById(R.id.defe);
	      	atak.setText(atk);
        	defe.setText(def);
    		AlertDialog.Builder diolog=new AlertDialog.Builder(this);
        	diolog.setView(adView)
        	.setTitle("攻击力/守备力").setNegativeButton("取消",null);
        	diolog.setPositiveButton("确定", new DialogInterface.OnClickListener() {
        	public void onClick(DialogInterface dialog, int which) {
        		atk=atak.getText().toString();
        		def=defe.getText().toString();
                setContentView(new KaMo(MainActivity.this));
        	}
        	});
        	diolog.show();
    break;
        case R.id.rlty:
        	LayoutInflater factr=LayoutInflater.from(MainActivity.this);
        	final View rltView=factr.inflate(R.layout.rltlog,null);
        	final Spinner kmrl=(Spinner)rltView.findViewById(R.id.rltkm);
        	final Spinner ktrl=(Spinner)rltView.findViewById(R.id.rltkt);
        	final Spinner krl=(Spinner)rltView.findViewById(R.id.rltk);
        	final Spinner bkrl=(Spinner)rltView.findViewById(R.id.rltbk);
        	final Spinner fwrl=(Spinner)rltView.findViewById(R.id.rltfw);
        	try{
        	String[] kmrlts={"普通", "银字", "金字", "红字"},ktrlts={"普通", "面闪", "纹理", "竖纹", "十字碎点","杂志彩虹","封印灵魂"},krlts={"普通", "面闪", "纹理", "竖纹", "十字碎点","碎玻璃"},bkrlts={"普通", "金边"},fwrlts={"普通","无", "银色","金色"};
        	ArrayAdapter<String> a = new ArrayAdapter<String>(this,android.R.layout.simple_spinner_item,kmrlts);
        	ArrayAdapter<String> b = new ArrayAdapter<String>(this,android.R.layout.simple_spinner_item,ktrlts);
        	ArrayAdapter<String> c = new ArrayAdapter<String>(this,android.R.layout.simple_spinner_item,krlts);
        	ArrayAdapter<String> d = new ArrayAdapter<String>(this,android.R.layout.simple_spinner_item,bkrlts);
        	ArrayAdapter<String> e = new ArrayAdapter<String>(this,android.R.layout.simple_spinner_item,fwrlts);
        	kmrl.setAdapter(a);
        	ktrl.setAdapter(b);
        	krl.setAdapter(c);
        	bkrl.setAdapter(d);
        	fwrl.setAdapter(e);
        	kmrl.setSelection(kmhg);
        	ktrl.setSelection(kthg);
        	krl.setSelection(khg);
        	bkrl.setSelection(bkhg);
        	fwrl.setSelection(fwhg);
        	kmrl.setOnItemSelectedListener(new OnItemSelectedListener() {
                @Override
                public void onItemSelected(AdapterView<?> parent, View view,
                        int position, long id) {
               	 kmhg=position;
                }
                @Override
                public void onNothingSelected(AdapterView<?> parent) {
                }
            });
        	ktrl.setOnItemSelectedListener(new OnItemSelectedListener() {
                @Override
                public void onItemSelected(AdapterView<?> parent, View view,
                        int position, long id) {
               	 kthg=position;
                }
                @Override
                public void onNothingSelected(AdapterView<?> parent) {
                }
            });
        	krl.setOnItemSelectedListener(new OnItemSelectedListener() {
                @Override
                public void onItemSelected(AdapterView<?> parent, View view,
                        int position, long id) {
               	 khg=position;
                }
                @Override
                public void onNothingSelected(AdapterView<?> parent) {
                }
            });
        	bkrl.setOnItemSelectedListener(new OnItemSelectedListener() {
                @Override
                public void onItemSelected(AdapterView<?> parent, View view,
                        int position, long id) {
               	 bkhg=position;
                }
                @Override
                public void onNothingSelected(AdapterView<?> parent) {
                }        	
            });
        	fwrl.setOnItemSelectedListener(new OnItemSelectedListener() {
                @Override
                public void onItemSelected(AdapterView<?> parent, View view,
                        int position, long id) {
               	 fwhg=position;
                }
                @Override
                public void onNothingSelected(AdapterView<?> parent) {
                }        	
            });
        	}catch(Exception e){}
        	final int a1=kmhg,a2=kthg,a3=khg,a4=bkhg,a5=fwhg;
        	
    		AlertDialog.Builder rltlog=new AlertDialog.Builder(this);
        	rltlog.setView(rltView)
        	.setTitle("罕贵度").setNegativeButton("取消",new DialogInterface.OnClickListener() {
        	public void onClick(DialogInterface dialog, int which) {
        		kthg=a1;kmhg=a2;khg=a3;bkhg=a4;fwhg=a5;
                setContentView(new KaMo(MainActivity.this));
        	}
        	});
        	rltlog.setPositiveButton("确定",new DialogInterface.OnClickListener() {
            	public void onClick(DialogInterface dialog, int which) {
                    setContentView(new KaMo(MainActivity.this));
            	}
            });
        	rltlog.show();
    break;
        case R.id.tpoutput:
        	katuout=true;
            setContentView(new KaMo(this));
            Toast.makeText(getApplicationContext(),"卡图已成功输出到"+picpath,Toast.LENGTH_SHORT).show();
            Uri data = Uri.parse("file://" +picpath+str1+".jpg");
            sendBroadcast(new  Intent(Intent.ACTION_MEDIA_SCANNER_SCAN_FILE, data));
    break;
        case R.id.tong:
        	mttype=1;
            setContentView(new KaMo(this));
    break;
        case R.id.su:
        	mttype=2;
            setContentView(new KaMo(this));
    break;
        case R.id.yong:
        	mttype=3;
            setContentView(new KaMo(this));
    break;
        case R.id.zhuang:
        	mttype=4;
            setContentView(new KaMo(this));
    break;
        case R.id.fan:
        	mttype=5;
            setContentView(new KaMo(this));
    break;
        case R.id.chang:
        	mttype=6;
            setContentView(new KaMo(this));
    break;
        case R.id.yi:
        	mttype=7;
            setContentView(new KaMo(this));
    break;
        case R.id.tpinput:
        	try{
            ShowPickDialog();}
        	catch(Exception e){
        		//TODO
        	}
    break;
        case R.id.rezhi:
            AlertDialog.Builder buil1 = new AlertDialog.Builder(this);
            buil1.setTitle("确定要重置卡图？").setIcon(android.R.drawable.ic_dialog_alert).setView(null)
                    .setNegativeButton("取消", null);
            buil1.setPositiveButton("确定", new DialogInterface.OnClickListener() {
            	public void onClick(DialogInterface dialog, int which) {
        	kamoselect=1;shuxselect=1;level=0;mttype=1;leng=1;
        	str1="";str2="种族/种類";xg="";
            kpmm="00000000";bq="©高橋和希 スタヅオ·ダイス/集英社";atk="0";def="0";pendxg=" ";pendkd="0";katuout=false;is_mt=false;is_p=false;kt=null;kbbh="MOSE-TC001";
            kthg=0;kmhg=0;khg=0;bkhg=0;fwhg=0;
            setContentView(new KaMo(MainActivity.this));
            }
            });
            buil1.show();
        	
    break;
        case R.id.ttbh:
            final EditText inputServer12 = new EditText(this);
            inputServer12.setText(kbbh);
            AlertDialog.Builder builder12 = new AlertDialog.Builder(this);
            builder12.setTitle("卡包编号").setIcon(android.R.drawable.ic_dialog_info).setView(inputServer12)
                    .setNegativeButton("取消", null);
            builder12.setPositiveButton("确定", new DialogInterface.OnClickListener() {

                public void onClick(DialogInterface dialog, int which) {
                   kbbh=inputServer12.getText().toString();
                   setContentView(new KaMo(MainActivity.this));
                 }
            });
            builder12.show();
    break;
        case R.id.ttmm:
            final EditText inputServer13 = new EditText(this);
            inputServer13.setText(kpmm);
            AlertDialog.Builder builder13 = new AlertDialog.Builder(this);
            builder13.setTitle("卡片密码").setIcon(android.R.drawable.ic_dialog_info).setView(inputServer13)
                    .setNegativeButton("取消", null);
            builder13.setPositiveButton("确定", new DialogInterface.OnClickListener() {

                public void onClick(DialogInterface dialog, int which) {
                   kpmm=inputServer13.getText().toString();
                   setContentView(new KaMo(MainActivity.this));
                 }
            });
            builder13.show();
    break;
        case R.id.bqwz:
            final EditText inputServer14 = new EditText(this);
            inputServer14.setText(bq);
            AlertDialog.Builder builder14 = new AlertDialog.Builder(this);
            builder14.setTitle("版权文字").setIcon(android.R.drawable.ic_dialog_info).setView(inputServer14)
                    .setNegativeButton("取消", null);
            builder14.setPositiveButton("确定", new DialogInterface.OnClickListener() {

                public void onClick(DialogInterface dialog, int which) {
                   bq=inputServer14.getText().toString();
                   setContentView(new KaMo(MainActivity.this));
                 }
            });
            builder14.show();
    break;
        case R.id.setread:
        	filetype=".mse-set";
            showDialog(openfileDialogId);
    break;
        case R.id.setdelete:
        	new File(setpath+"set").delete();
        	new File(setpath+"image").delete();
        	Toast.makeText(getApplicationContext(),"已清除自动存档",Toast.LENGTH_SHORT).show();
    break;
        case R.id.setwrite:
        	Toast.makeText(getApplicationContext(),"生成存档中，請稍候",Toast.LENGTH_SHORT).show();
        	if(SetUp() && ZipUp()){
        		Toast.makeText(getApplicationContext(),"保存到"+filepath,Toast.LENGTH_SHORT).show();}
        	else{
        		Toast.makeText(getApplicationContext(),"存档失败",Toast.LENGTH_SHORT).show();}
    break;
        case R.id.exit:
            AlertDialog.Builder buil = new AlertDialog.Builder(this);
            buil.setTitle("确定退出程序？").setIcon(android.R.drawable.ic_dialog_alert).setView(null)
                    .setNegativeButton("取消", null);
            buil.setPositiveButton("确定", new DialogInterface.OnClickListener() {
            	public void onClick(DialogInterface dialog, int which) {
            	 finish();
                  }
            });
            buil.show();
    break;
        case R.id.refresh:
            refresh(this);
    break;
        case R.id.sce:
        	Intent it=new Intent(this, ScriptActivity.class);
            startActivity(it);
    break;
        case R.id.cdb:
        	if(kpmm.equals("00000000")){
    			Toast.makeText(getApplicationContext(),"卡片密码不能全为0！！",Toast.LENGTH_SHORT).show();}
        	else{Intent itt=new Intent(this, DEActivity.class);
            startActivity(itt);}
    break;
        default:
    return super.onOptionsItemSelected(item);
        }
    return true;
    }
public static void refresh(Activity activity){
        activity.setContentView(new KaMo(activity));
    }

public static boolean SetUp(){ 
	try {
		File file=new File(setpath+"set");
		if(file.exists()){file.delete();}
		FileWriter fw = new FileWriter(setpath+"set"); 
		fw.flush(); 
		fw.write("mse version: 0.3.8\ngame: yugioh\nstylesheet: 9thGen\nstyling:\n\tyugioh-9thGen:"
				+ "\n\t\tpendulum_mask: ");
		if(!is_p){fw.write("normal");}else{if(bigp){fw.write("big");}else{fw.write("small");}}
		fw.write("\ncard: ");
		fw.write("\n\thas styling: true");
		fw.write("\n\tstyling data:");
		fw.write("\n\t\tpendulum_mask: ");
		if(!is_p){fw.write("normal");}else{if(bigp){fw.write("big");}else{fw.write("small");}}
		if(!is_p){fw.write("\n\textra data:");
			fw.write("\n\t\tyugioh-9thGen:");
			fw.write("\n\t\t\tpendulum text: "+pendxg);
			fw.write("\n\t\t\tpendulum scale 1: "+pendkd);
			fw.write("\n\t\t\tpendulum scale 2: "+pendkd);
			}
		fw.write("\n\tcard_type:");
		switch (kamoselect){
		case 1:
			fw.write("normal monster");
	break;
		case 2:
			fw.write("effect monster");
	break;
		case 3:
			fw.write("ritual monster");
	break;
		case 4:
			fw.write("fusion monster");
	break;
		case 5:
			fw.write("synchro monster");
	break;
		case 6:
			fw.write("xyz monster");
	break;
		case 9:
			fw.write("dark synchro monster");
	break;
		case 10:
			fw.write("spell card");
	break;
		case 11:
			fw.write("trap card");
	break;
		case 12:
			fw.write("token monster");
	break;
		case 13:
			fw.write("slifer");
	break;
		case 14:
			fw.write("obelisk");
	break;
		case 15:
			fw.write("ra");
	break;
		case 16:
			fw.write("token monster");
		}
		fw.write("\n\tname: "+str1
				+"\n\tattribute: ");
		switch (shuxselect){
		case 1:
			fw.write("light");
	break;
		case 2:
			fw.write("dark");
	break;
		case 3:
			fw.write("fire");
	break;
		case 4:
			fw.write("wind");
	break;
		case 5:
			fw.write("water");
	break;
		case 6:
			fw.write("earth");
	break;
		case 7:
			fw.write("divine");
	break;
		default:if(kamoselect==10){fw.write("spell");}else{fw.write("trap");}
	break;
		}
		fw.write("\n\tlevel: ");
		if(is_mt){
		if(kamoselect==10){fw.write("魔法卡");}else{fw.write("陷阱卡");}
		switch(mttype){
		case 1:
	break;
		case 2:
			fw.write("<sym-auto>$</sym-auto>");
	break;
		case 3:
			fw.write("<sym-auto>%</sym-auto>");
	break;
		case 4:
			fw.write("<sym-auto>+</sym-auto>");
	break;
		case 5:
			fw.write("<sym-auto>!</sym-auto>");
	break;
		case 6:
			fw.write("<sym-auto>&</sym-auto>");
	break;
		case 7:
			fw.write("<sym-auto>#</sym-auto>");
	break;}}
		else{for(int i=level;i>0;i--){fw.write("<sym-auto>*</sym-auto>");}}
		fw.write("\n\timage: image");
		fw.write("\n\ttype 1: <word-list-monster>"+zhongz+"</word-list-monster>");
		fw.write("\n\ttype 2: <word-list-card>"+zlei1+"<word-list-card>");
		if(!zlei2.equals("")){
		fw.write("\n\ttype 3: <word-list-card>"+zlei2+"<word-list-card>");}
		if(!zlei3.equals("")){		
			fw.write("\n\ttype 4: <word-list-card>"+zlei3+"<word-list-card>");}
		fw.write("\n\ttype : ");
		if(!zlei3.equals("")){fw.write("<word-list-card>"+zlei1+"<word-list-card><sep> / </sep><word-list-card>"
				+zlei2+"<word-list-card><sep> / </sep><word-list-card>"+zlei3+"<word-list-card>");}
		else{if(!zlei2.equals("")){fw.write("<word-list-card>"+zlei1
				+"<word-list-card><sep> / </sep><word-list-card>"+zlei2+"<word-list-card>");}
		else{fw.write("<word-list-card>"+zlei1+"<word-list-card>");}}
		fw.write("\n\tnumber: "+kbbh);
		fw.write("\n\trule text: "+xg);
		fw.write("\n\tattack: "+atk);
		fw.write("\n\tdefense: "+def);
		fw.write("\n\tgamecode: "+kpmm);
		fw.write("\n\trarity: 普通");
		fw.write("\n\tcopyright: "+bq);
		fw.write("\nversion control: \n\ttype: none\napprentice code: ");
		fw.close();
	} catch (Exception e) {
		e.printStackTrace();
		return false;
	}
	return true;
}
		
public boolean ZipUp(){ 
	try {
		ZipOutputStream outZip = new ZipOutputStream(new FileOutputStream(filepath+str1+".mse-set"));
		ZipEntry zipEntry = new ZipEntry("set");
		FileInputStream inputStream = new FileInputStream(setpath+"set");
		outZip.putNextEntry(zipEntry);
		int len;
		byte[] buffer = new byte[100000];
		while ((len = inputStream.read(buffer)) != -1) {
			outZip.write(buffer, 0, len);
		}
		zipEntry = new ZipEntry("image");
		inputStream.close();
		inputStream = new FileInputStream(setpath+"image");
		outZip.putNextEntry(zipEntry);
		int le;
		buffer = new byte[100000];
		while ((le = inputStream.read(buffer)) != -1) {
			outZip.write(buffer, 0, le);
		}
		Toast.makeText(getApplicationContext(),"存档完毕",Toast.LENGTH_SHORT).show();
		inputStream.close();
		outZip.finish();
		outZip.close();
	} catch (Exception e) {
		e.printStackTrace();
		return false;
	}
	return true;
}

public void upZipFile(File zipFile, String folderPath) throws ZipException, IOException 
     {
         File desDir = new File(folderPath);
         if(!desDir.exists())
         {
             desDir.mkdirs();
         }
         
         ZipFile zf = new ZipFile(zipFile);  
          for (Enumeration<?> entries = zf.entries(); entries.hasMoreElements();) 
          { 
              ZipEntry entry = ((ZipEntry)entries.nextElement());  
             InputStream in = zf.getInputStream(entry);  
             String str = folderPath + File.separator + entry.getName(); 
             str = new String(str.getBytes("8859_1"), "UTF-8");  
             File desFile = new File(str);  
             if (!desFile.exists()) 
             {
                  File fileParentDir = desFile.getParentFile();  
                  if (!fileParentDir.exists()) 
                  { 
                      fileParentDir.mkdirs();  
                  }  
                      desFile.createNewFile();  
             }  
             OutputStream out = new FileOutputStream(desFile);  
             byte buffer[] = new byte[1024];  
             int realLength;  
             while ((realLength = in.read(buffer)) > 0) 
             {
                 out.write(buffer, 0, realLength);  
             }
             in.close();  
            out.close(); 
			Toast.makeText(getApplicationContext(),"数据处理中请稍候。。。",Toast.LENGTH_SHORT).show(); 
          }
     }

@Override  
protected Dialog onCreateDialog(int id) {  
    if(id==openfileDialogId){  
        Map<String, Integer> images = new HashMap<String, Integer>();  
        // 设置各文件类型的图标
        images.put(OpenFileDialog.sRoot, R.drawable.filedialog_root);   // 根目录图标  
        images.put(OpenFileDialog.sParent, R.drawable.filedialog_folder_up);    //返回上一层的图标  
        images.put(OpenFileDialog.sFolder, R.drawable.filedialog_folder);   //文件夹图标  
        images.put("mse-set", R.drawable.filedialog_setfile);   //set文件图标  
        images.put(OpenFileDialog.sEmpty, R.drawable.filedialog_root);  
        Dialog dialog = OpenFileDialog.createDialog(id, this, "打开文件", new CallbackBundle() {  
            @Override  
            public void callback(Bundle bundle) {  
                readpath = bundle.getString("path");

                try {
    				upZipFile(new File(readpath), setpath);
    			} catch (ZipException e) {
    				Toast.makeText(getApplicationContext(),"不是有效的存档文件",Toast.LENGTH_SHORT).show();
    				e.printStackTrace();
    			} catch (IOException e) {
    				Toast.makeText(getApplicationContext(),"读取失败，请重试",Toast.LENGTH_SHORT).show();
    				e.printStackTrace();
    			}
                readFileByLines(setpath+"set");
                new File(setpath+"set").delete();             
            }  
        },
        ".mse-set;",  
        images);  
        return dialog;  
    }  
    return null;  
}  
 
public void readFileByLines(String fileName) {
        File file = new File(fileName);
        BufferedReader reader = null;
        try {
            InputStreamReader isr = new InputStreamReader(new FileInputStream(file), "UTF-8");
            reader = new BufferedReader(isr);
            Toast.makeText(getApplicationContext(),"读取中。。。",Toast.LENGTH_SHORT).show();
            String tempString = "";
            while (!(tempString = reader.readLine()).contains("apprentice code:")) {
                stringoperate(tempString);
            }
            	kt=Bitmap.createScaledBitmap(decodeUriAsBitmap(imageUri), 600, 600, true);
            reader.close();
            setContentView(new KaMo(MainActivity.this));
        	Toast.makeText(getApplicationContext(),"读取存档完毕",Toast.LENGTH_SHORT).show();
        } catch (IOException e) {
        	Toast.makeText(getApplicationContext(),"出错请重试",Toast.LENGTH_SHORT).show();
            e.printStackTrace();
        } finally {
            if (reader != null) {
                try {
                    reader.close();
                } catch (IOException e1) {
                	Toast.makeText(getApplicationContext(),"出错请重试",Toast.LENGTH_SHORT).show();
                }
            }
        }
    }

private boolean readSet(File path){
	if(! path.exists()){
		return false;
	}

    BufferedReader reader = null;
    InputStreamReader isr;
	try {
		isr = new InputStreamReader(new FileInputStream(path), "UTF-8");
    reader = new BufferedReader(isr);
    String tempString = "";
    while (!(tempString = reader.readLine()).equals("apprentice code: ")) {
        stringoperate(tempString);
    }
    	kt=Bitmap.createScaledBitmap(decodeUriAsBitmap(imageUri), 600, 600, true);
    reader.close();
	} catch (Exception e) {
		return false;
	}
	return true;
}
private void stringoperate(String tempString) {
		tempString=tempString.replaceAll("\t", "");
		tempString=tempString.replaceAll("<sym-auto>", "");
		tempString=tempString.replaceAll("</sym-auto>", "");
		tempString=tempString.replaceAll("<word-list-monster>", "");
		tempString=tempString.replaceAll("</word-list-monster>", "");
		tempString=tempString.replaceAll("<word-list-card>", "");
		tempString=tempString.replaceAll("</word-list-card>", "");
		tempString=tempString.replaceAll("<sep>", "");
		tempString=tempString.replaceAll("</sep>", "");
		tempString=tempString.replaceAll("<i>", "");
		tempString=tempString.replaceAll("</i>", "");
		tempString=tempString.replaceAll("<favor>", "");
		tempString=tempString.replaceAll("</favor>", "");
		
		if(end==0){
			if(tempString.contains("name:")){
				end=0;
				str1=tempString.replaceFirst("name: ", "");
			}

			if(tempString.contains("pendlum_mask:")){
				end=0;
				if(tempString.contains("normal")){is_p=false;}else{is_p=true;}
			}
			if(tempString.contains("card_type:")){
				if(tempString.contains("normal")){kamoselect=1;}else{if(tempString.contains("effect")){kamoselect=2;
				}else{if(tempString.contains("ritual")){kamoselect=3;}else{if(tempString.contains("fusion")){kamoselect=4;
				}else{if(tempString.contains("dark")){kamoselect=9;}else{if(tempString.contains("xyz")){kamoselect=6;
				}else{if(tempString.contains("synchro")){kamoselect=5;}else{if(tempString.contains("spell")){kamoselect=10;
				}else{if(tempString.contains("trap")){kamoselect=11;}else{if(tempString.contains("token")){kamoselect=12;
				}else{if(tempString.contains("slifer")){kamoselect=13;}else{if(tempString.contains("obelisk")){kamoselect=14;
				}else{if(tempString.contains("ra")){kamoselect=14;}else{
					kamoselect=1;
					Toast.makeText(getApplicationContext(),"暂不支持自定义卡膜",Toast.LENGTH_SHORT).show();
				}}}}}}}}}}}}}
				if(kamoselect==9||kamoselect==11){
					is_mt=true;
				}
			}

			if(tempString.contains("attribute:")){
				end=0;
				if(tempString.contains("light")){shuxselect=1;}else{if(tempString.contains("dark")){shuxselect=2;
				}else{if(tempString.contains("fire")){shuxselect=3;}else{if(tempString.contains("wind")){shuxselect=4;
				}else{if(tempString.contains("water")){shuxselect=5;}else{if(tempString.contains("earth")){shuxselect=6;
				}else{if(tempString.contains("divine")){shuxselect=7;}else{
					if(tempString.contains("spell")){kamoselect=10;}else{if(tempString.contains("trap")){kamoselect=11;}
					}}}}}}}}
			}
			if(tempString.contains("level:")){
				end=0;
				tempString=tempString.replaceFirst("level: ", "");
				level=tempString.length();
			}
			if(tempString.contains("number:")){
				end=0;
				kbbh=tempString.replaceFirst("number: ", "");
			}
			if(tempString.contains("rule text:")){
				xg=tempString.replaceFirst("rule text: ", "");
				end=-1;
			}
			if(tempString.contains("pendulum text:")){
				pendxg=tempString.replaceFirst("pendulum text: ", "");
				end=1;
			}
			if(tempString.contains("pendulum scale 1:")){
				end=0;
				pendkd=tempString.replaceFirst("pendulum scale 1: ", "");
			}
			if(tempString.contains("pendulum scale 2:")&& !tempString.replaceFirst("pendulum scale 2: ", "").equals(pendkd)){
				end=0;
				Toast.makeText(getApplicationContext(),"左右刻度不一致!已读取右刻度",Toast.LENGTH_SHORT).show();
				pendkd=tempString.replaceFirst("pendulum scale 2: ", "");
			}
			if(tempString.contains("attack:")){
				end=0;
				atk=tempString.replaceFirst("attack: ", "");
			}
			if(tempString.contains("defense:")){
				end=0;
				def=tempString.replaceFirst("defense: ", "");
			}
			if(tempString.contains("type 1:")){
				end=0;
				zhongz=tempString.replaceFirst("type 1: ", "");
			}
			if(tempString.contains("type 2:")){
				end=0;
				zlei1=tempString.replaceFirst("type 2: ", "");
			}
			if(tempString.contains("type 3:")){
				end=0;
				zlei2=tempString.replaceFirst("type 3: ", "");
			}
			if(tempString.contains("type 4:")){
				end=0;
				zlei3=tempString.replaceFirst("type 4: ", "");
			}
			if(tempString.contains("gamecode:")){
				end=0;
				kpmm=tempString.replaceFirst("gamecode: ", "");
			}
			if(tempString.contains("copyright:")){
				end=0;
				bq=tempString.replaceFirst("copyright: ", "");
			}
		}else{
			if(!tempString.contains(": ")){
				if(end==-1){xg += "\n"+tempString;}else{pendxg += "\n"+tempString;}}
			else{end=0;}
		}
	}

/**
 * ：采用哈希算法实现
 */
	public String trans(String words) {
		
			final String jianti = "万与丑专业丛东丝丢两严丧个丬丰临为丽举么义乌乐乔习乡书买乱争于亏云亘亚产亩亲亵亸亿仅从仑仓仪们价众优伙会伛伞伟传伤伥伦伧伪伫体余佣佥侠侣侥侦侧侨侩侪侬俣俦俨俩俪俭债倾偬偻偾偿傥傧储傩儿兑兖党兰关兴兹养兽冁内冈册写军农冢冯冲决况冻净凄凉凌减凑凛几凤凫凭凯击凼凿刍划刘则刚创删别刬刭刽刿剀剂剐剑剥剧劝办务劢动励劲劳势勋勐勚匀匦匮区医华协单卖卢卤卧卫却卺厂厅历厉压厌厍厕厢厣厦厨厩厮县参叆叇双发变叙叠叶号叹叽吁后吓吕吗吣吨听启吴呒呓呕呖呗员呙呛呜咏咔咙咛咝咤咴咸哌响哑哒哓哔哕哗哙哜哝哟唛唝唠唡唢唣唤唿啧啬啭啮啰啴啸喷喽喾嗫呵嗳嘘嘤嘱噜噼嚣嚯团园囱围囵国图圆圣圹场坂坏块坚坛坜坝坞坟坠垄垅垆垒垦垧垩垫垭垯垱垲垴埘埙埚埝埯堑堕塆墙壮声壳壶壸处备复够头夸夹夺奁奂奋奖奥妆妇妈妩妪妫姗姜娄娅娆娇娈娱娲娴婳婴婵婶媪嫒嫔嫱嬷孙学孪宁宝实宠审宪宫宽宾寝对寻导寿将尔尘尧尴尸尽层屃屉届属屡屦屿岁岂岖岗岘岙岚岛岭岳岽岿峃峄峡峣峤峥峦崂崃崄崭嵘嵚嵛嵝嵴巅巩巯币帅师帏帐帘帜带帧帮帱帻帼幂幞干并广庄庆庐庑库应庙庞废庼廪开异弃张弥弪弯弹强归当录彟彦彻径徕御忆忏忧忾怀态怂怃怄怅怆怜总怼怿恋恳恶恸恹恺恻恼恽悦悫悬悭悯惊惧惨惩惫惬惭惮惯愍愠愤愦愿慑慭憷懑懒懔戆戋戏戗战戬户扎扑扦执扩扪扫扬扰抚抛抟抠抡抢护报担拟拢拣拥拦拧拨择挂挚挛挜挝挞挟挠挡挢挣挤挥挦捞损捡换捣据捻掳掴掷掸掺掼揸揽揿搀搁搂搅携摄摅摆摇摈摊撄撑撵撷撸撺擞攒敌敛数斋斓斗斩断无旧时旷旸昙昼昽显晋晒晓晔晕晖暂暧札术朴机杀杂权条来杨杩杰极构枞枢枣枥枧枨枪枫枭柜柠柽栀栅标栈栉栊栋栌栎栏树栖样栾桊桠桡桢档桤桥桦桧桨桩梦梼梾检棂椁椟椠椤椭楼榄榇榈榉槚槛槟槠横樯樱橥橱橹橼檐檩欢欤欧歼殁殇残殒殓殚殡殴毁毂毕毙毡毵氇气氢氩氲汇汉污汤汹沓沟没沣沤沥沦沧沨沩沪沵泞泪泶泷泸泺泻泼泽泾洁洒洼浃浅浆浇浈浉浊测浍济浏浐浑浒浓浔浕涂涌涛涝涞涟涠涡涢涣涤润涧涨涩淀渊渌渍渎渐渑渔渖渗温游湾湿溃溅溆溇滗滚滞滟滠满滢滤滥滦滨滩滪漤潆潇潋潍潜潴澜濑濒灏灭灯灵灾灿炀炉炖炜炝点炼炽烁烂烃烛烟烦烧烨烩烫烬热焕焖焘煅煳熘爱爷牍牦牵牺犊犟状犷犸犹狈狍狝狞独狭狮狯狰狱狲猃猎猕猡猪猫猬献獭玑玙玚玛玮环现玱玺珉珏珐珑珰珲琎琏琐琼瑶瑷璇璎瓒瓮瓯电画畅畲畴疖疗疟疠疡疬疮疯疱疴痈痉痒痖痨痪痫痴瘅瘆瘗瘘瘪瘫瘾瘿癞癣癫癯皑皱皲盏盐监盖盗盘眍眦眬着睁睐睑瞒瞩矫矶矾矿砀码砖砗砚砜砺砻砾础硁硅硕硖硗硙硚确硷碍碛碜碱碹磙礼祎祢祯祷祸禀禄禅离秃秆种积称秽秾稆税稣稳穑穷窃窍窑窜窝窥窦窭竖竞笃笋笔笕笺笼笾筑筚筛筜筝筹签简箓箦箧箨箩箪箫篑篓篮篱簖籁籴类籼粜粝粤粪粮糁糇紧絷纟纠纡红纣纤纥约级纨纩纪纫纬纭纮纯纰纱纲纳纴纵纶纷纸纹纺纻纼纽纾线绀绁绂练组绅细织终绉绊绋绌绍绎经绐绑绒结绔绕绖绗绘给绚绛络绝绞统绠绡绢绣绤绥绦继绨绩绪绫绬续绮绯绰绱绲绳维绵绶绷绸绹绺绻综绽绾绿缀缁缂缃缄缅缆缇缈缉缊缋缌缍缎缏缐缑缒缓缔缕编缗缘缙缚缛缜缝缞缟缠缡缢缣缤缥缦缧缨缩缪缫缬缭缮缯缰缱缲缳缴缵罂网罗罚罢罴羁羟羡翘翙翚耢耧耸耻聂聋职聍联聩聪肃肠肤肷肾肿胀胁胆胜胧胨胪胫胶脉脍脏脐脑脓脔脚脱脶脸腊腌腘腭腻腼腽腾膑臜舆舣舰舱舻艰艳艹艺节芈芗芜芦苁苇苈苋苌苍苎苏苘苹茎茏茑茔茕茧荆荐荙荚荛荜荞荟荠荡荣荤荥荦荧荨荩荪荫荬荭荮药莅莜莱莲莳莴莶获莸莹莺莼萚萝萤营萦萧萨葱蒇蒉蒋蒌蓝蓟蓠蓣蓥蓦蔷蔹蔺蔼蕲蕴薮藁藓虏虑虚虫虬虮虽虾虿蚀蚁蚂蚕蚝蚬蛊蛎蛏蛮蛰蛱蛲蛳蛴蜕蜗蜡蝇蝈蝉蝎蝼蝾螀螨蟏衅衔补衬衮袄袅袆袜袭袯装裆裈裢裣裤裥褛褴襁襕见观觃规觅视觇览觉觊觋觌觍觎觏觐觑觞触觯詟誉誊讠计订讣认讥讦讧讨让讪讫训议讯记讱讲讳讴讵讶讷许讹论讻讼讽设访诀证诂诃评诅识诇诈诉诊诋诌词诎诏诐译诒诓诔试诖诗诘诙诚诛诜话诞诟诠诡询诣诤该详诧诨诩诪诫诬语诮误诰诱诲诳说诵诶请诸诹诺读诼诽课诿谀谁谂调谄谅谆谇谈谊谋谌谍谎谏谐谑谒谓谔谕谖谗谘谙谚谛谜谝谞谟谠谡谢谣谤谥谦谧谨谩谪谫谬谭谮谯谰谱谲谳谴谵谶谷豮贝贞负贠贡财责贤败账货质贩贪贫贬购贮贯贰贱贲贳贴贵贶贷贸费贺贻贼贽贾贿赀赁赂赃资赅赆赇赈赉赊赋赌赍赎赏赐赑赒赓赔赕赖赗赘赙赚赛赜赝赞赟赠赡赢赣赪赵赶趋趱趸跃跄跖跞践跶跷跸跹跻踊踌踪踬踯蹑蹒蹰蹿躏躜躯车轧轨轩轪轫转轭轮软轰轱轲轳轴轵轶轷轸轹轺轻轼载轾轿辀辁辂较辄辅辆辇辈辉辊辋辌辍辎辏辐辑辒输辔辕辖辗辘辙辚辞辩辫边辽达迁过迈运还这进远违连迟迩迳迹适选逊递逦逻遗遥邓邝邬邮邹邺邻郁郄郏郐郑郓郦郧郸酝酦酱酽酾酿释里鉅鉴銮錾钆钇针钉钊钋钌钍钎钏钐钑钒钓钔钕钖钗钘钙钚钛钝钞钟钠钡钢钣钤钥钦钧钨钩钪钫钬钭钮钯钰钱钲钳钴钵钶钷钸钹钺钻钼钽钾钿铀铁铂铃铄铅铆铈铉铊铋铍铎铏铐铑铒铕铗铘铙铚铛铜铝铞铟铠铡铢铣铤铥铦铧铨铪铫铬铭铮铯铰铱铲铳铴铵银铷铸铹铺铻铼铽链铿销锁锂锃锄锅锆锇锈锉锊锋锌锍锎锏锐锑锒锓锔锕锖锗错锚锜锞锟锠锡锢锣锤锥锦锨锩锫锬锭键锯锰锱锲锳锴锵锶锷锸锹锺锻锼锽锾锿镀镁镂镃镆镇镈镉镊镌镍镎镏镐镑镒镕镖镗镙镚镛镜镝镞镟镠镡镢镣镤镥镦镧镨镩镪镫镬镭镮镯镰镱镲镳镴镶长门闩闪闫闬闭问闯闰闱闲闳间闵闶闷闸闹闺闻闼闽闾闿阀阁阂阃阄阅阆阇阈阉阊阋阌阍阎阏阐阑阒阓阔阕阖阗阘阙阚阛队阳阴阵阶际陆陇陈陉陕陧陨险随隐隶隽难雏雠雳雾霁霉霭靓静靥鞑鞒鞯鞴韦韧韨韩韪韫韬韵页顶顷顸项顺须顼顽顾顿颀颁颂颃预颅领颇颈颉颊颋颌颍颎颏颐频颒颓颔颕颖颗题颙颚颛颜额颞颟颠颡颢颣颤颥颦颧风飏飐飑飒飓飔飕飖飗飘飙飚飞飨餍饤饥饦饧饨饩饪饫饬饭饮饯饰饱饲饳饴饵饶饷饸饹饺饻饼饽饾饿馀馁馂馃馄馅馆馇馈馉馊馋馌馍馎馏馐馑馒馓馔馕马驭驮驯驰驱驲驳驴驵驶驷驸驹驺驻驼驽驾驿骀骁骂骃骄骅骆骇骈骉骊骋验骍骎骏骐骑骒骓骔骕骖骗骘骙骚骛骜骝骞骟骠骡骢骣骤骥骦骧髅髋髌鬓魇魉鱼鱽鱾鱿鲀鲁鲂鲄鲅鲆鲇鲈鲉鲊鲋鲌鲍鲎鲏鲐鲑鲒鲓鲔鲕鲖鲗鲘鲙鲚鲛鲜鲝鲞鲟鲠鲡鲢鲣鲤鲥鲦鲧鲨鲩鲪鲫鲬鲭鲮鲯鲰鲱鲲鲳鲴鲵鲶鲷鲸鲹鲺鲻鲼鲽鲾鲿鳀鳁鳂鳃鳄鳅鳆鳇鳈鳉鳊鳋鳌鳍鳎鳏鳐鳑鳒鳓鳔鳕鳖鳗鳘鳙鳛鳜鳝鳞鳟鳠鳡鳢鳣鸟鸠鸡鸢鸣鸤鸥鸦鸧鸨鸩鸪鸫鸬鸭鸮鸯鸰鸱鸲鸳鸴鸵鸶鸷鸸鸹鸺鸻鸼鸽鸾鸿鹀鹁鹂鹃鹄鹅鹆鹇鹈鹉鹊鹋鹌鹍鹎鹏鹐鹑鹒鹓鹔鹕鹖鹗鹘鹚鹛鹜鹝鹞鹟鹠鹡鹢鹣鹤鹥鹦鹧鹨鹩鹪鹫鹬鹭鹯鹰鹱鹲鹳鹴鹾麦麸黄黉黡黩黪黾鼋鼌鼍鼗鼹齄齐齑齿龀龁龂龃龄龅龆龇龈龉龊龋龌龙龚龛龟志制咨里系范松没尝尝闹面准钟别闲干尽脏拼";
			 final String fanti = "萬與醜專業叢東絲丟兩嚴喪個爿豐臨為麗舉麼義烏樂喬習鄉書買亂爭於虧雲亙亞產畝親褻嚲億僅從侖倉儀們價眾優夥會傴傘偉傳傷倀倫傖偽佇體餘傭僉俠侶僥偵側僑儈儕儂俁儔儼倆儷儉債傾傯僂僨償儻儐儲儺兒兌兗黨蘭關興茲養獸囅內岡冊寫軍農塚馮衝決況凍淨淒涼淩減湊凜幾鳳鳧憑凱擊氹鑿芻劃劉則剛創刪別剗剄劊劌剴劑剮劍剝劇勸辦務勱動勵勁勞勢勳猛勩勻匭匱區醫華協單賣盧鹵臥衛卻巹廠廳曆厲壓厭厙廁廂厴廈廚廄廝縣參靉靆雙發變敘疊葉號歎嘰籲後嚇呂嗎唚噸聽啟吳嘸囈嘔嚦唄員咼嗆嗚詠哢嚨嚀噝吒噅鹹呱響啞噠嘵嗶噦嘩噲嚌噥喲嘜嗊嘮啢嗩唕喚呼嘖嗇囀齧囉嘽嘯噴嘍嚳囁嗬噯噓嚶囑嚕劈囂謔團園囪圍圇國圖圓聖壙場阪壞塊堅壇壢壩塢墳墜壟壟壚壘墾坰堊墊埡墶壋塏堖塒塤堝墊垵塹墮壪牆壯聲殼壺壼處備複夠頭誇夾奪奩奐奮獎奧妝婦媽嫵嫗媯姍薑婁婭嬈嬌孌娛媧嫻嫿嬰嬋嬸媼嬡嬪嬙嬤孫學孿寧寶實寵審憲宮寬賓寢對尋導壽將爾塵堯尷屍盡層屭屜屆屬屢屨嶼歲豈嶇崗峴嶴嵐島嶺嶽崠巋嶨嶧峽嶢嶠崢巒嶗崍嶮嶄嶸嶔崳嶁脊巔鞏巰幣帥師幃帳簾幟帶幀幫幬幘幗冪襆幹並廣莊慶廬廡庫應廟龐廢廎廩開異棄張彌弳彎彈強歸當錄彠彥徹徑徠禦憶懺憂愾懷態慫憮慪悵愴憐總懟懌戀懇惡慟懨愷惻惱惲悅愨懸慳憫驚懼慘懲憊愜慚憚慣湣慍憤憒願懾憖怵懣懶懍戇戔戲戧戰戩戶紮撲扡執擴捫掃揚擾撫拋摶摳掄搶護報擔擬攏揀擁攔擰撥擇掛摯攣掗撾撻挾撓擋撟掙擠揮撏撈損撿換搗據撚擄摑擲撣摻摜摣攬撳攙擱摟攪攜攝攄擺搖擯攤攖撐攆擷擼攛擻攢敵斂數齋斕鬥斬斷無舊時曠暘曇晝曨顯晉曬曉曄暈暉暫曖劄術樸機殺雜權條來楊榪傑極構樅樞棗櫪梘棖槍楓梟櫃檸檉梔柵標棧櫛櫳棟櫨櫟欄樹棲樣欒棬椏橈楨檔榿橋樺檜槳樁夢檮棶檢欞槨櫝槧欏橢樓欖櫬櫚櫸檟檻檳櫧橫檣櫻櫫櫥櫓櫞簷檁歡歟歐殲歿殤殘殞殮殫殯毆毀轂畢斃氈毿氌氣氫氬氳彙漢汙湯洶遝溝沒灃漚瀝淪滄渢溈滬濔濘淚澩瀧瀘濼瀉潑澤涇潔灑窪浹淺漿澆湞溮濁測澮濟瀏滻渾滸濃潯濜塗湧濤澇淶漣潿渦溳渙滌潤澗漲澀澱淵淥漬瀆漸澠漁瀋滲溫遊灣濕潰濺漵漊潷滾滯灩灄滿瀅濾濫灤濱灘澦濫瀠瀟瀲濰潛瀦瀾瀨瀕灝滅燈靈災燦煬爐燉煒熗點煉熾爍爛烴燭煙煩燒燁燴燙燼熱煥燜燾煆糊溜愛爺牘犛牽犧犢強狀獷獁猶狽麅獮獰獨狹獅獪猙獄猻獫獵獼玀豬貓蝟獻獺璣璵瑒瑪瑋環現瑲璽瑉玨琺瓏璫琿璡璉瑣瓊瑤璦璿瓔瓚甕甌電畫暢佘疇癤療瘧癘瘍鬁瘡瘋皰屙癰痙癢瘂癆瘓癇癡癉瘮瘞瘺癟癱癮癭癩癬癲臒皚皺皸盞鹽監蓋盜盤瞘眥矓著睜睞瞼瞞矚矯磯礬礦碭碼磚硨硯碸礪礱礫礎硜矽碩硤磽磑礄確鹼礙磧磣堿镟滾禮禕禰禎禱禍稟祿禪離禿稈種積稱穢穠穭稅穌穩穡窮竊竅窯竄窩窺竇窶豎競篤筍筆筧箋籠籩築篳篩簹箏籌簽簡籙簀篋籜籮簞簫簣簍籃籬籪籟糴類秈糶糲粵糞糧糝餱緊縶糸糾紆紅紂纖紇約級紈纊紀紉緯紜紘純紕紗綱納紝縱綸紛紙紋紡紵紖紐紓線紺絏紱練組紳細織終縐絆紼絀紹繹經紿綁絨結絝繞絰絎繪給絢絳絡絕絞統綆綃絹繡綌綏絛繼綈績緒綾緓續綺緋綽緔緄繩維綿綬繃綢綯綹綣綜綻綰綠綴緇緙緗緘緬纜緹緲緝縕繢緦綞緞緶線緱縋緩締縷編緡緣縉縛縟縝縫縗縞纏縭縊縑繽縹縵縲纓縮繆繅纈繚繕繒韁繾繰繯繳纘罌網羅罰罷羆羈羥羨翹翽翬耮耬聳恥聶聾職聹聯聵聰肅腸膚膁腎腫脹脅膽勝朧腖臚脛膠脈膾髒臍腦膿臠腳脫腡臉臘醃膕齶膩靦膃騰臏臢輿艤艦艙艫艱豔艸藝節羋薌蕪蘆蓯葦藶莧萇蒼苧蘇檾蘋莖蘢蔦塋煢繭荊薦薘莢蕘蓽蕎薈薺蕩榮葷滎犖熒蕁藎蓀蔭蕒葒葤藥蒞蓧萊蓮蒔萵薟獲蕕瑩鶯蓴蘀蘿螢營縈蕭薩蔥蕆蕢蔣蔞藍薊蘺蕷鎣驀薔蘞藺藹蘄蘊藪槁蘚虜慮虛蟲虯蟣雖蝦蠆蝕蟻螞蠶蠔蜆蠱蠣蟶蠻蟄蛺蟯螄蠐蛻蝸蠟蠅蟈蟬蠍螻蠑螿蟎蠨釁銜補襯袞襖嫋褘襪襲襏裝襠褌褳襝褲襇褸襤繈襴見觀覎規覓視覘覽覺覬覡覿覥覦覯覲覷觴觸觶讋譽謄訁計訂訃認譏訐訌討讓訕訖訓議訊記訒講諱謳詎訝訥許訛論訩訟諷設訪訣證詁訶評詛識詗詐訴診詆謅詞詘詔詖譯詒誆誄試詿詩詰詼誠誅詵話誕詬詮詭詢詣諍該詳詫諢詡譸誡誣語誚誤誥誘誨誑說誦誒請諸諏諾讀諑誹課諉諛誰諗調諂諒諄誶談誼謀諶諜謊諫諧謔謁謂諤諭諼讒諮諳諺諦謎諞諝謨讜謖謝謠謗諡謙謐謹謾謫譾謬譚譖譙讕譜譎讞譴譫讖穀豶貝貞負貟貢財責賢敗賬貨質販貪貧貶購貯貫貳賤賁貰貼貴貺貸貿費賀貽賊贄賈賄貲賃賂贓資賅贐賕賑賚賒賦賭齎贖賞賜贔賙賡賠賧賴賵贅賻賺賽賾贗讚贇贈贍贏贛赬趙趕趨趲躉躍蹌蹠躒踐躂蹺蹕躚躋踴躊蹤躓躑躡蹣躕躥躪躦軀車軋軌軒軑軔轉軛輪軟轟軲軻轤軸軹軼軤軫轢軺輕軾載輊轎輈輇輅較輒輔輛輦輩輝輥輞輬輟輜輳輻輯轀輸轡轅轄輾轆轍轔辭辯辮邊遼達遷過邁運還這進遠違連遲邇逕跡適選遜遞邐邏遺遙鄧鄺鄔郵鄒鄴鄰鬱郤郟鄶鄭鄆酈鄖鄲醞醱醬釅釃釀釋裏钜鑒鑾鏨釓釔針釘釗釙釕釷釺釧釤鈒釩釣鍆釹鍚釵鈃鈣鈈鈦鈍鈔鍾鈉鋇鋼鈑鈐鑰欽鈞鎢鉤鈧鈁鈥鈄鈕鈀鈺錢鉦鉗鈷缽鈳鉕鈽鈸鉞鑽鉬鉭鉀鈿鈾鐵鉑鈴鑠鉛鉚鈰鉉鉈鉍鈹鐸鉶銬銠鉺銪鋏鋣鐃銍鐺銅鋁銱銦鎧鍘銖銑鋌銩銛鏵銓鉿銚鉻銘錚銫鉸銥鏟銃鐋銨銀銣鑄鐒鋪鋙錸鋱鏈鏗銷鎖鋰鋥鋤鍋鋯鋨鏽銼鋝鋒鋅鋶鐦鐧銳銻鋃鋟鋦錒錆鍺錯錨錡錁錕錩錫錮鑼錘錐錦鍁錈錇錟錠鍵鋸錳錙鍥鍈鍇鏘鍶鍔鍤鍬鍾鍛鎪鍠鍰鎄鍍鎂鏤鎡鏌鎮鎛鎘鑷鐫鎳鎿鎦鎬鎊鎰鎔鏢鏜鏍鏰鏞鏡鏑鏃鏇鏐鐔钁鐐鏷鑥鐓鑭鐠鑹鏹鐙鑊鐳鐶鐲鐮鐿鑔鑣鑞鑲長門閂閃閆閈閉問闖閏闈閑閎間閔閌悶閘鬧閨聞闥閩閭闓閥閣閡閫鬮閱閬闍閾閹閶鬩閿閽閻閼闡闌闃闠闊闋闔闐闒闕闞闤隊陽陰陣階際陸隴陳陘陝隉隕險隨隱隸雋難雛讎靂霧霽黴靄靚靜靨韃鞽韉韝韋韌韍韓韙韞韜韻頁頂頃頇項順須頊頑顧頓頎頒頌頏預顱領頗頸頡頰頲頜潁熲頦頤頻頮頹頷頴穎顆題顒顎顓顏額顳顢顛顙顥纇顫顬顰顴風颺颭颮颯颶颸颼颻飀飄飆飆飛饗饜飣饑飥餳飩餼飪飫飭飯飲餞飾飽飼飿飴餌饒餉餄餎餃餏餅餑餖餓餘餒餕餜餛餡館餷饋餶餿饞饁饃餺餾饈饉饅饊饌饢馬馭馱馴馳驅馹駁驢駔駛駟駙駒騶駐駝駑駕驛駘驍罵駰驕驊駱駭駢驫驪騁驗騂駸駿騏騎騍騅騌驌驂騙騭騤騷騖驁騮騫騸驃騾驄驏驟驥驦驤髏髖髕鬢魘魎魚魛魢魷魨魯魴魺鮁鮃鯰鱸鮋鮓鮒鮊鮑鱟鮍鮐鮭鮚鮳鮪鮞鮦鰂鮜鱠鱭鮫鮮鮺鯗鱘鯁鱺鰱鰹鯉鰣鰷鯀鯊鯇鮶鯽鯒鯖鯪鯕鯫鯡鯤鯧鯝鯢鯰鯛鯨鯵鯴鯔鱝鰈鰏鱨鯷鰮鰃鰓鱷鰍鰒鰉鰁鱂鯿鰠鼇鰭鰨鰥鰩鰟鰜鰳鰾鱈鱉鰻鰵鱅鰼鱖鱔鱗鱒鱯鱤鱧鱣鳥鳩雞鳶鳴鳲鷗鴉鶬鴇鴆鴣鶇鸕鴨鴞鴦鴒鴟鴝鴛鴬鴕鷥鷙鴯鴰鵂鴴鵃鴿鸞鴻鵐鵓鸝鵑鵠鵝鵒鷳鵜鵡鵲鶓鵪鶤鵯鵬鵮鶉鶊鵷鷫鶘鶡鶚鶻鶿鶥鶩鷊鷂鶲鶹鶺鷁鶼鶴鷖鸚鷓鷚鷯鷦鷲鷸鷺鸇鷹鸌鸏鸛鸘鹺麥麩黃黌黶黷黲黽黿鼂鼉鞀鼴齇齊齏齒齔齕齗齟齡齙齠齜齦齬齪齲齷龍龔龕龜誌製谘裡係範鬆沒嚐嘗鬨麵準鐘彆閒乾儘臟拚";

		String word = "";
		Map<Character, Character> map=new HashMap<Character, Character>();
		for(int i=0;i<jianti.length();i++){
			map.put(jianti.charAt(i),fanti.charAt(i));
		}		
		for (int i = 0; i < words.length(); i++) {
			char tempChar = words.charAt(i);
			Character character=map.get(tempChar);
			char fantiChar;
			if (character == null) {
				fantiChar = tempChar;
			} else{
				fantiChar=character;
			}
			word +=(fantiChar);
		}
		return word;
	}
}
