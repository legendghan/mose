package com.legendhan.mose;

import java.io.File;
import java.io.FileOutputStream;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.RectF;
import android.graphics.Typeface;
import android.text.Layout.Alignment;
import android.text.StaticLayout;
import android.text.TextPaint;
import android.util.Log;
import android.view.View;

    public class KaMo extends View {
	Bitmap bmp,shux,star,mrkt,mticon,kb,ktovly,kovly,fw;
	public KaMo(Context context) {
		super(context);
		Resources res=context.getResources();
	if(!(MainActivity.hei==0)){
		switch(MainActivity.khg){
		case 0:
			kovly=Bitmap.createScaledBitmap(BitmapFactory.decodeResource(res ,R.drawable.nu), (int)(MainActivity.width), (int)(MainActivity.height),true);
			break;
		case 1:
			kovly=Bitmap.createScaledBitmap(BitmapFactory.decodeResource(res ,R.drawable.k_r), (int)(MainActivity.width), (int)(MainActivity.height),true);
			break;
		case 2:
			kovly=Bitmap.createScaledBitmap(BitmapFactory.decodeResource(res ,R.drawable.k_hr), (int)(MainActivity.width), (int)(MainActivity.height),true);
			break;
		case 3:
			kovly=Bitmap.createScaledBitmap(BitmapFactory.decodeResource(res ,R.drawable.k_ur), (int)(MainActivity.width), (int)(MainActivity.height),true);
			break;
		case 4:
			kovly=Bitmap.createScaledBitmap(BitmapFactory.decodeResource(res ,R.drawable.k_sr), (int)(MainActivity.width), (int)(MainActivity.height),true);
			break;
		case 5:
			kovly=Bitmap.createScaledBitmap(BitmapFactory.decodeResource(res ,R.drawable.k_dt), (int)(MainActivity.width), (int)(MainActivity.height),true);
			break;
		}		
		switch(MainActivity.fwhg){
		case 0:
			fw=Bitmap.createScaledBitmap(BitmapFactory.decodeResource(res ,R.drawable.fw_n), (int)((MainActivity.r-MainActivity.l)), (int)((MainActivity.b-MainActivity.t)),true);
			break;
		case 1:
			fw=Bitmap.createScaledBitmap(BitmapFactory.decodeResource(res ,R.drawable.nu), (int)((MainActivity.r-MainActivity.l)), (int)((MainActivity.b-MainActivity.t)),true);
			break;
		case 2:
			fw=Bitmap.createScaledBitmap(BitmapFactory.decodeResource(res ,R.drawable.fw_s), (int)((MainActivity.r-MainActivity.l)), (int)((MainActivity.b-MainActivity.t)),true);
			break;
		case 3:
			fw=Bitmap.createScaledBitmap(BitmapFactory.decodeResource(res ,R.drawable.fw_g), (int)((MainActivity.r-MainActivity.l)), (int)((MainActivity.b-MainActivity.t)),true);
			break;
		}	
		switch(MainActivity.kthg){
		case 0:
			ktovly=Bitmap.createScaledBitmap(BitmapFactory.decodeResource(res ,R.drawable.nu), (int)((MainActivity.right3-MainActivity.left3)), (int)((MainActivity.bottom3-MainActivity.top3)),true);
			break;
		case 1:
			ktovly=Bitmap.createScaledBitmap(BitmapFactory.decodeResource(res ,R.drawable.kt_r), (int)((MainActivity.right3-MainActivity.left3)), (int)((MainActivity.bottom3-MainActivity.top3)),true);
			break;
		case 2:
			ktovly=Bitmap.createScaledBitmap(BitmapFactory.decodeResource(res ,R.drawable.kt_hr), (int)((MainActivity.right3-MainActivity.left3)), (int)((MainActivity.bottom3-MainActivity.top3)),true);
			break;
		case 3:
			ktovly=Bitmap.createScaledBitmap(BitmapFactory.decodeResource(res ,R.drawable.kt_ur), (int)((MainActivity.right3-MainActivity.left3)), (int)((MainActivity.bottom3-MainActivity.top3)),true);
			break;
		case 4:
			ktovly=Bitmap.createScaledBitmap(BitmapFactory.decodeResource(res ,R.drawable.kt_sr), (int)((MainActivity.right3-MainActivity.left3)), (int)((MainActivity.bottom3-MainActivity.top3)),true);
			break;
		case 5:
			ktovly=Bitmap.createScaledBitmap(BitmapFactory.decodeResource(res ,R.drawable.kt_zz), (int)((MainActivity.right3-MainActivity.left3)), (int)((MainActivity.bottom3-MainActivity.top3)),true);
			break;
		case 6:
			ktovly=Bitmap.createScaledBitmap(BitmapFactory.decodeResource(res ,R.drawable.kt_of), (int)((MainActivity.right3-MainActivity.left3)), (int)((MainActivity.bottom3-MainActivity.top3)),true);
			break;
		}
		mrkt=BitmapFactory.decodeResource(res ,R.drawable.mrkt);
		if(MainActivity.is_mt==false){
			if(MainActivity.kamoselect==6){
				star=Bitmap.createScaledBitmap(BitmapFactory.decodeResource(res ,R.drawable.starxyz), (int)((MainActivity.right2-MainActivity.left2)), (int)((MainActivity.bottom2-MainActivity.top2)),true);
				}
			else{
				if(MainActivity.kamoselect==1234567890){
					star=Bitmap.createScaledBitmap(BitmapFactory.decodeResource(res ,R.drawable.stards), (int)((MainActivity.right2-MainActivity.left2)), (int)((MainActivity.bottom2-MainActivity.top2)),true);
					}
				else{
					star=Bitmap.createScaledBitmap(BitmapFactory.decodeResource(res ,R.drawable.star), (int)((MainActivity.right2-MainActivity.left2)), (int)((MainActivity.bottom2-MainActivity.top2)),true);
					}
				}
			}
		switch (MainActivity.mttype) {
		case 1:
			mticon=Bitmap.createScaledBitmap(BitmapFactory.decodeResource(res ,R.drawable.nu), (int)((MainActivity.right2-MainActivity.left2)*0.5), (int)((MainActivity.bottom2-MainActivity.top2)*0.5),true);
    break;
        case 2:
			mticon=Bitmap.createScaledBitmap(BitmapFactory.decodeResource(res ,R.drawable.mqp), (int)((MainActivity.right2-MainActivity.left2)*0.5), (int)((MainActivity.bottom2-MainActivity.top2)*0.5),true);
    break;
        case 3:
			mticon=Bitmap.createScaledBitmap(BitmapFactory.decodeResource(res ,R.drawable.mct), (int)((MainActivity.right2-MainActivity.left2)*0.5), (int)((MainActivity.bottom2-MainActivity.top2)*0.5),true);
    break;
        case 4:
			mticon=Bitmap.createScaledBitmap(BitmapFactory.decodeResource(res ,R.drawable.mep), (int)((MainActivity.right2-MainActivity.left2)*0.5), (int)((MainActivity.bottom2-MainActivity.top2)*0.5),true);
    break;
        case 5:
			mticon=Bitmap.createScaledBitmap(BitmapFactory.decodeResource(res ,R.drawable.mcr), (int)((MainActivity.right2-MainActivity.left2)*0.5), (int)((MainActivity.bottom2-MainActivity.top2)*0.5),true);
    break;
        case 6:
			mticon=Bitmap.createScaledBitmap(BitmapFactory.decodeResource(res ,R.drawable.mfd), (int)((MainActivity.right2-MainActivity.left2)*0.5), (int)((MainActivity.bottom2-MainActivity.top2)*0.5),true);
    break;
        case 7:
			mticon=Bitmap.createScaledBitmap(BitmapFactory.decodeResource(res ,R.drawable.mrt), (int)((MainActivity.right2-MainActivity.left2)*0.5), (int)((MainActivity.bottom2-MainActivity.top2)*0.5),true);
    break;
		}
//		if(!MainActivity.is_p){
		switch (MainActivity.kamoselect) {
        case 1:
        	if(!MainActivity.is_p){
    			bmp=Bitmap.createScaledBitmap(BitmapFactory.decodeResource(res ,R.drawable.kmn), (int)((MainActivity.width)), (int)((MainActivity.height)),true);
        	}else if(MainActivity.bigp){
    			bmp=Bitmap.createScaledBitmap(BitmapFactory.decodeResource(res ,R.drawable.kmnpb), (int)((MainActivity.width)), (int)((MainActivity.height)),true);
        	}else{
    			bmp=Bitmap.createScaledBitmap(BitmapFactory.decodeResource(res ,R.drawable.kmnps), (int)((MainActivity.width)), (int)((MainActivity.height)),true);
        	}
    break;
        case 2:
        	if(!MainActivity.is_p){
    			bmp=Bitmap.createScaledBitmap(BitmapFactory.decodeResource(res ,R.drawable.kme), (int)((MainActivity.width)), (int)((MainActivity.height)),true);
        	}else if(MainActivity.bigp){
    			bmp=Bitmap.createScaledBitmap(BitmapFactory.decodeResource(res ,R.drawable.kmepb), (int)((MainActivity.width)), (int)((MainActivity.height)),true);
        	}else{
    			bmp=Bitmap.createScaledBitmap(BitmapFactory.decodeResource(res ,R.drawable.kmeps), (int)((MainActivity.width)), (int)((MainActivity.height)),true);
        	}
    break;
        case 3:
        	if(!MainActivity.is_p){
    			bmp=Bitmap.createScaledBitmap(BitmapFactory.decodeResource(res ,R.drawable.kmr), (int)((MainActivity.width)), (int)((MainActivity.height)),true);
        	}else if(MainActivity.bigp){
    			bmp=Bitmap.createScaledBitmap(BitmapFactory.decodeResource(res ,R.drawable.kmrpb), (int)((MainActivity.width)), (int)((MainActivity.height)),true);
        	}else{
    			bmp=Bitmap.createScaledBitmap(BitmapFactory.decodeResource(res ,R.drawable.kmrps), (int)((MainActivity.width)), (int)((MainActivity.height)),true);
        	}
    break;
        case 4:
        	if(!MainActivity.is_p){
    			bmp=Bitmap.createScaledBitmap(BitmapFactory.decodeResource(res ,R.drawable.kmf), (int)((MainActivity.width)), (int)((MainActivity.height)),true);
        	}else if(MainActivity.bigp){
    			bmp=Bitmap.createScaledBitmap(BitmapFactory.decodeResource(res ,R.drawable.kmfpb), (int)((MainActivity.width)), (int)((MainActivity.height)),true);
        	}else{
    			bmp=Bitmap.createScaledBitmap(BitmapFactory.decodeResource(res ,R.drawable.kmfps), (int)((MainActivity.width)), (int)((MainActivity.height)),true);
        	}
    break;
        case 5:
        	if(!MainActivity.is_p){
    			bmp=Bitmap.createScaledBitmap(BitmapFactory.decodeResource(res ,R.drawable.kms), (int)((MainActivity.width)), (int)((MainActivity.height)),true);
        	}else if(MainActivity.bigp){
    			bmp=Bitmap.createScaledBitmap(BitmapFactory.decodeResource(res ,R.drawable.kmspb), (int)((MainActivity.width)), (int)((MainActivity.height)),true);
        	}else{
    			bmp=Bitmap.createScaledBitmap(BitmapFactory.decodeResource(res ,R.drawable.kmspx), (int)((MainActivity.width)), (int)((MainActivity.height)),true);
        	}
    break;
        case 6:
        	if(!MainActivity.is_p){
    			bmp=Bitmap.createScaledBitmap(BitmapFactory.decodeResource(res ,R.drawable.kmx), (int)((MainActivity.width)), (int)((MainActivity.height)),true);
        	}else if(MainActivity.bigp){
    			bmp=Bitmap.createScaledBitmap(BitmapFactory.decodeResource(res ,R.drawable.kmxpb), (int)((MainActivity.width)), (int)((MainActivity.height)),true);
        	}else{
    			bmp=Bitmap.createScaledBitmap(BitmapFactory.decodeResource(res ,R.drawable.kmxps), (int)((MainActivity.width)), (int)((MainActivity.height)),true);
        	}
    break;
        case 9:
			bmp=Bitmap.createScaledBitmap(BitmapFactory.decodeResource(res ,R.drawable.kmm), (int)((MainActivity.width)), (int)((MainActivity.height)),true);
    break;
        case 11:
			bmp=Bitmap.createScaledBitmap(BitmapFactory.decodeResource(res ,R.drawable.kmt), (int)((MainActivity.width)), (int)((MainActivity.height)),true);
    break;
        case 12:
			bmp=Bitmap.createScaledBitmap(BitmapFactory.decodeResource(res ,R.drawable.kmtk), (int)((MainActivity.width)), (int)((MainActivity.height)),true);
    break;
        case 16:
			bmp=Bitmap.createScaledBitmap(BitmapFactory.decodeResource(res ,R.drawable.kmbtk), (int)((MainActivity.width)), (int)((MainActivity.height)),true);
    break;
			}

    	if(!MainActivity.is_p){
			kb=Bitmap.createScaledBitmap(BitmapFactory.decodeResource(res ,R.drawable.kb_g), (int)((MainActivity.width)), (int)((MainActivity.height)),true);
    	}else if(MainActivity.bigp){
			kb=Bitmap.createScaledBitmap(BitmapFactory.decodeResource(res ,R.drawable.kb_pgb), (int)((MainActivity.width)), (int)((MainActivity.height)),true);
    	}else{
			kb=Bitmap.createScaledBitmap(BitmapFactory.decodeResource(res ,R.drawable.kb_pgs), (int)((MainActivity.width)), (int)((MainActivity.height)),true);
}
/*		}
		else {
	//		if(MainActivity.bigp){
			switch (MainActivity.kamoselect) {
	        case 1:
	        	bmp=BitmapFactory.decodeResource(res ,R.drawable.kmnpb);
	    break;
	        case 2:
	        	bmp=BitmapFactory.decodeResource(res ,R.drawable.kmepb);
	    break;
	        case 3:
	        	bmp=BitmapFactory.decodeResource(res ,R.drawable.kmrpb);
	    break;
	        case 4:
	        	bmp=BitmapFactory.decodeResource(res ,R.drawable.kmfpb);
	    break;
	        case 5:
	        	bmp=BitmapFactory.decodeResource(res ,R.drawable.kmspb);
	    break;
	        case 6:
	        	bmp=BitmapFactory.decodeResource(res ,R.drawable.kmxpb);
	    break;
				}	
			kb=BitmapFactory.decodeResource(res ,R.drawable.kb_pgb);
		}
		else{
			switch (MainActivity.kamoselect) {
	        case 1:
	        	bmp=BitmapFactory.decodeResource(res ,R.drawable.kmnps);
	    break;
	        case 2:
	        	bmp=BitmapFactory.decodeResource(res ,R.drawable.kmeps);
	    break;
	        case 3:
	        	bmp=BitmapFactory.decodeResource(res ,R.drawable.kmrps);
	    break;
	        case 4:
	        	bmp=BitmapFactory.decodeResource(res ,R.drawable.kmfps);
	    break;
	        case 5:
	        	bmp=BitmapFactory.decodeResource(res ,R.drawable.kmspx);
	    break;
	        case 6:
	        	bmp=BitmapFactory.decodeResource(res ,R.drawable.kmxps);
	    break;
				}	
			kb=BitmapFactory.decodeResource(res ,R.drawable.kb_pgs);
		}
			*/
//	}
	if(MainActivity.kamoselect==9){
		shux=BitmapFactory.decodeResource(res ,R.drawable.a8);	
		}
	else{
		if(MainActivity.kamoselect==11){
			shux=BitmapFactory.decodeResource(res ,R.drawable.a9);
			}
		else{
			if(MainActivity.kamoselect==16){
				shux=BitmapFactory.decodeResource(res ,R.drawable.nu);
				}
			else{
		switch (MainActivity.shuxselect) {
        case 1:
    		shux=BitmapFactory.decodeResource(res ,R.drawable.a1);
    break;
        case 2:
    		shux=BitmapFactory.decodeResource(res ,R.drawable.a2);
    break;
        case 3:
    		shux=BitmapFactory.decodeResource(res ,R.drawable.a3);
    break;
        case 4:
    		shux=BitmapFactory.decodeResource(res ,R.drawable.a4);
    break;
        case 5:
    		shux=BitmapFactory.decodeResource(res ,R.drawable.a5);
    break;
        case 6:
    		shux=BitmapFactory.decodeResource(res ,R.drawable.a6);
    break;
        case 7:
    		shux=BitmapFactory.decodeResource(res ,R.drawable.a7);
    break;
		}
		}
		}
	}}}
	
	@Override
	public void onDraw(Canvas canvas) {
		super.onDraw(canvas);
		
		if(MainActivity.hei==0){
//			MainActivity.hei=canvas.getHeight();MainActivity.wid=canvas.getWidth();
    		
		}else{
			
		float height=MainActivity.height,width=MainActivity.width,left2=MainActivity.left2
				,top2=MainActivity.top2,right2=MainActivity.right2
				,bottom2=MainActivity.bottom2,le=MainActivity.le,tp=MainActivity.tp,
				le2,tp2,bt2,rg2;

		RectF rectkm,rect1,rect2,rect3,rect3s,rect3b,rectkthg,rect4,rectfw;
	/*		height=MainActivity.height;
			width=MainActivity.width;
			left2=MainActivity.left2;
			top2=MainActivity.top2;
			right2=MainActivity.right2;
			bottom2=MainActivity.bottom2;
			le=MainActivity.le;
			tp=MainActivity.tp;
			*/
	    rectkm=new RectF(0,0,MainActivity.right,MainActivity.bottom);
	    rect1=new RectF(MainActivity.left1,MainActivity.top1,MainActivity.right1,MainActivity.bottom1);
	    le2=left2;tp2=top2;bt2=bottom2;rg2=right2;
	    if(MainActivity.is_p){tp2=MainActivity.top2p;}
	    if(MainActivity.kamoselect==6){le2=MainActivity.left2x;
	    rg2=MainActivity.right2x;}
	    rect2=new RectF(le2,tp2,rg2,bt2);
	    rect3=new RectF(MainActivity.left3,MainActivity.top3,MainActivity.right3,MainActivity.bottom3);
	    rect3b=new RectF(MainActivity.left3b,MainActivity.top3b,MainActivity.right3b,MainActivity.bottom3b);
	    rect3s=new RectF(MainActivity.left3s,MainActivity.top3s,MainActivity.right3s,MainActivity.bottom3s);
	    rectkthg=new RectF(MainActivity.left3,MainActivity.top3,MainActivity.right3,MainActivity.bottom3);
	    rect4=new RectF(MainActivity.left4,MainActivity.top4,MainActivity.right4,MainActivity.bottom4);
	    rectfw=new RectF(MainActivity.l,MainActivity.t,MainActivity.r,MainActivity.b);
		

		String atkbuzu="",defbuzu="",atde="",blank="";
		try{
	    switch (MainActivity.atk.length()){
	    case 0:
	    	atkbuzu="        ";
	    	break;
	    case 1:
	    	atkbuzu="      ";
	    	break;
	    case 2:
	    	atkbuzu="    ";
	    	break;
	    case 3:
	    	atkbuzu="  ";
	    	break;
	    default:
	    	atkbuzu="";
	    	break;
	    }
	    switch (MainActivity.def.length()){
	    case 0:
	    	defbuzu="        ";
	    	break;
	    case 1:
	    	defbuzu="      ";
	    	break;
	    case 2:
	    	defbuzu="    ";
	    	break;
	    case 3:
	    	defbuzu="  ";
	    	break;
	    default:
	    	defbuzu="";
	    	break;
	    }
		atde=atkbuzu+MainActivity.atk+"          "+defbuzu+MainActivity.def;
		
	    le=MainActivity.left;tp=MainActivity.top;
	    canvas.translate((float)(le), (float)(tp));

		
		Paint paint = new Paint(Paint.ANTI_ALIAS_FLAG);
		
		if(!MainActivity.is_p){
			if(MainActivity.kt!=null){
				canvas.drawBitmap(MainActivity.kt, null, rect3, paint);}
				else{
					canvas.drawBitmap(mrkt, null, rect3, paint);}
		}else if(MainActivity.bigp){
			if(MainActivity.kt!=null){
				canvas.drawBitmap(MainActivity.kt, null, rect3b, paint);}
				else{
					canvas.drawBitmap(mrkt, null, rect3b, paint);}
		}else{
			if(MainActivity.kt!=null){
				canvas.drawBitmap(MainActivity.kt, null, rect3s, paint);}
				else{
					canvas.drawBitmap(mrkt, null, rect3s, paint);}}
		canvas.drawBitmap(ktovly, null, rectkthg, paint);
		canvas.drawBitmap(bmp, null, rectkm, paint);
		canvas.drawBitmap(shux, null, rect1, paint);
		if(MainActivity.is_mt==false & MainActivity.level!=0){
			for(int n=0;n<13-MainActivity.level;n++){
				canvas.drawBitmap(star, null, rect2, new Paint());
    			if(MainActivity.kamoselect==6){
    				le2=(float) (le2+0.0666*width);
    				}
    			else{
    					le2=(float) (le2-0.0666*width);
    				}
    			rg2=(float) (le2+bt2-tp2);
    	    	rect2=new RectF(le2,tp2,rg2,bt2);
			}
		}
	    Typeface km,mbsc,pala,kgp;
	    km = Typeface.createFromAsset(getContext().getAssets(),"jdxlsf.ttf"); 
	    pala = Typeface.createFromAsset(getContext().getAssets(),"pala.ttf"); 
	    mbsc = Typeface.createFromAsset(getContext().getAssets(),"MatrixBoldSmallCaps.ttf"); 
	    kgp = Typeface.createFromAsset(getContext().getAssets(),"KGP.otf");
	    switch(MainActivity.kmhg){
	    case 0:
	    if(MainActivity.kamoselect==6|MainActivity.kamoselect==1234567890|MainActivity.kamoselect==9|MainActivity.kamoselect==11){
	    paint.setColor(Color.WHITE);}
	    break;
	    case 1:
	    paint.setColor(Color.GRAY);
	    break;
	    case 2:
	    paint.setColor(Color.YELLOW);
	    break;
	    case 3:
	    paint.setColor(Color.RED);
	    break;
	    }
	    paint.setTypeface(km);
	    paint.setTextSize((int)(0.059*height));
	    if(MainActivity.str1.length()>9){
	    	paint.setTextSize((float)(paint.getTextSize()*9/MainActivity.str1.length()));
	    }
	    if(MainActivity.is_p){
			canvas.drawText(MainActivity.str1, (float)(width*0.069), (float)(height*0.098), paint);
			}else{canvas.drawText(MainActivity.str1, (float)(width*0.069), (float)(height*0.096), paint);}
	    paint.setTextSize((int)(0.028*height));
	    paint.setColor(Color.BLACK);
		if(!MainActivity.is_mt){
		canvas.drawText("【"+MainActivity.str2+"】", (float)(width*0.056), (float)(height*0.775), paint);
		paint.setTypeface(mbsc);
	    paint.setTextSize((int)(0.038*height));
	    canvas.drawText(atde, (float)(width*0.647-0.04*paint.getTextSize()*(MainActivity.atk.length()+MainActivity.def.length())), (float)(height*0.935), paint);
		}else{
	    	if(MainActivity.mttype!=1){
	    		blank="    ";
	    		canvas.drawBitmap(mticon, null, rect4, paint);
	    	}
	    	if(MainActivity.kamoselect==9){
	    		MainActivity.mt_type="【魔法卡"+blank+"】";
	    	}
	    	else{if(MainActivity.kamoselect==11){
	    		MainActivity.mt_type="【陷阱卡"+blank+"】";
	    	}else{MainActivity.mt_type="";}}
    	    paint.setTypeface(km);
    	    paint.setTextSize((int)(0.04*height));
    	    canvas.drawText(MainActivity.mt_type, (float)(width*0.65-blank.length()*0.015*width), (float)(height*0.156), paint);
	    }

	    paint.setTextSize((int)(0.026*height));
		paint.setTypeface(pala);
		if(MainActivity.kamoselect==6|MainActivity.kamoselect==1234567890){paint.setColor(Color.WHITE);}
		if(MainActivity.is_p){canvas.drawText(MainActivity.kbbh, (float)(width*0.081), (float)(height*0.935), paint);}
		else{canvas.drawText(MainActivity.kbbh, (float)(width*0.688), (float)(height*0.735), paint);}
		canvas.drawText(MainActivity.kpmm, (float)(width*0.04), (float)(height*0.972), paint);
		paint.setTextSize((int)(0.02*height));
		paint.setTypeface(kgp);
		canvas.drawText(MainActivity.bq, (float)(width*0.48), (float)(height*0.97), paint);
		paint.setTypeface(mbsc);
		paint.setColor(Color.BLACK);
		TextPaint textPaint = new TextPaint(); 
		if(MainActivity.xg.length()<=100){
			textPaint.setTextSize((int)(0.027*height));}
				else{if(MainActivity.xg.length()<=140)
				{textPaint.setTextSize((int)(0.023*height));}
					else{if(MainActivity.xg.length()<=200)
					{textPaint.setTextSize((int)(0.020*height));}
						else{textPaint.setTextSize((int)(0.015*height));}}}
		textPaint.setAntiAlias(true);
		textPaint.setTypeface(km);
		StaticLayout layout;
		String xg="";
		if(MainActivity.kamoselect==16){
			xg="這張卡可以當作衍生物使用。";}
		else if(MainActivity.kamoselect==12){
			xg="這張卡可以當作「"+MainActivity.str1+"」使用。";}
		else{
			xg=MainActivity.xg;
		}

		layout = new StaticLayout(xg, textPaint, (int) (0.85*width),  
		        Alignment.ALIGN_NORMAL, 1.0F, 0, true);
		canvas.save();
		if(MainActivity.is_mt){
		canvas.translate( (float)(width*0.081), (float)(height*0.752));}
		else{
		canvas.translate( (float)(width*0.081), (float)(height*0.777));}
		layout.draw(canvas);
		if(MainActivity.kamoselect==12||MainActivity.kamoselect==16){
			textPaint.setTextSize((int)(0.018*height));
			StaticLayout layoutt;
			String xgg;
			if(MainActivity.kamoselect==12){
				xgg="#這張卡當作「"+MainActivity.str1+"」以外的衍生物使用的場合，那個種族·屬性·等級·攻擊力·守備力適用。                           ";}
			else{
				xgg=MainActivity.xg;}
			layoutt = new StaticLayout(xgg, textPaint, (int) (0.85*width),  
			        Alignment.ALIGN_NORMAL, 1.0F, 0, true);
			if(MainActivity.kamoselect==12){
				canvas.translate( (float)(width*0.0), (float)(height*0.145-(int)(1+xgg.length()/29)*textPaint.getTextSize()));
			}else{
				canvas.translate( (float)(width*0.0), (float)(height*0.18-(int)(1+xgg.length()/29)*textPaint.getTextSize()));
				}
			layoutt.draw(canvas);
		}
		else if(MainActivity.is_p==true){
			if(MainActivity.pendxg.length()<=56){
				textPaint.setTextSize((int)(0.027*height));}
				else{if(MainActivity.pendxg.length()<=162)
					{textPaint.setTextSize((int)(0.018*height));}
					else{textPaint.setTextSize((int)(0.015*height));}}
			StaticLayout layoutp = new StaticLayout(MainActivity.pendxg, textPaint, (int) (0.7*width),  
			        Alignment.ALIGN_NORMAL, 1.0F, 0, true);
			if(MainActivity.bigp){
				canvas.translate( (float)(width*0.073), (float)(-height*0.145));
			}else{
				canvas.translate( (float)(width*0.073), (float)(-height*0.11));
			}
			layoutp.draw(canvas);
    	    paint.setTextSize((int)(0.055*height));

    	    if(MainActivity.bigp){
        	    if(MainActivity.pendkd.length()==1){
        	    	canvas.drawText(MainActivity.pendkd, (float)(-width*0.065), (float)(height*0.09), paint);
        	    	canvas.drawText(MainActivity.pendkd, (float)(width*0.725), (float)(height*0.09), paint);}
        	    else{
        	    	canvas.drawText(MainActivity.pendkd, (float)(-width*0.085), (float)(height*0.09), paint);
        	    	canvas.drawText(MainActivity.pendkd, (float)(width*0.71), (float)(height*0.09), paint);}
        	    }
        	    else{
            	    if(MainActivity.pendkd.length()==1){
            	    	canvas.drawText(MainActivity.pendkd, (float)(-width*0.065), (float)(height*0.073), paint);
            	    	canvas.drawText(MainActivity.pendkd, (float)(width*0.725), (float)(height*0.073), paint);}
            	    else{
            	    	canvas.drawText(MainActivity.pendkd, (float)(-width*0.085), (float)(height*0.073), paint);
            	    	canvas.drawText(MainActivity.pendkd, (float)(width*0.71), (float)(height*0.073), paint);}
            	}
			paint.setTypeface(km);
		}
		canvas.restore();
		if(MainActivity.bkhg==1){
			canvas.drawBitmap(kb, null, rectkm, new Paint());}
		canvas.drawBitmap(kovly, null, rectkm, new Paint());
		canvas.drawBitmap(fw, null, rectfw, new Paint());
		
		MainActivity.SetUp();
		
		if(MainActivity.katuout){
			try {
				setDrawingCacheEnabled(true);
				Bitmap bamp=this.getDrawingCache();
				Bitmap ykb=Bitmap.createBitmap(bamp, (int)le, (int)tp, (int)width, (int)height);
				ykb.compress(Bitmap.CompressFormat.JPEG,100,new FileOutputStream(
            	new File(MainActivity.picpath+MainActivity.str1+".jpg")));
				setDrawingCacheEnabled(false);
            	MainActivity.katuout=false;
            	bamp.recycle();
            	ykb.recycle();
			}
			catch (Exception e) {
					Log.e("file writing error", e.toString());}
		}
		
		if(!(kb.isRecycled()))kb.recycle();
		if(!(bmp.isRecycled()))bmp.recycle();
		if(!(shux.isRecycled()))shux.recycle();
		if(!(star.isRecycled()))star.recycle();
		if(!(mrkt.isRecycled()))mrkt.recycle();
		if(!(mticon.isRecycled()))mticon.recycle();
		if(!(ktovly.isRecycled()))ktovly.recycle();
		if(!(fw.isRecycled()))fw.recycle();
		
		System.gc();}
	catch(Exception e){
		
	}		
	}
	}
	
	
}
