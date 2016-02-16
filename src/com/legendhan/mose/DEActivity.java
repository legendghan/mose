package com.legendhan.mose2;

import android.app.*;
import android.content.*;
import android.database.*;
import android.database.sqlite.*;
import android.os.*;
import android.support.v4.app.*;
import android.view.*;
import android.widget.*;
import java.util.*;

import android.support.v4.app.Fragment;

public class DEActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);

		while(ide.substring(0, 1).equals("0")){ide=ide.replaceFirst("0", "");
		id=Integer.parseInt(ide);}
		dataget(MainActivity.str1+"!@#$%^&*");
		switch(MainActivity.shuxselect){
		case 1:attribute=16;break;case 2:attribute=1;break;case 3:attribute=8;break;case 4:attribute=2;break;
		case 5:attribute=4;break;case 6:attribute=64;break;case 7:attribute=32;break;
		}

		if(MainActivity.kamoselect==10){
			level=0;
			type&=0x2;
			switch(MainActivity.mttype){
			case 3:type&=0x20000;break;
			case 4:type&=0x10000;break;
			case 5:type&=0x40000;break;
			case 6:type&=0x80000;break;
			case 7:type&=0x80;break;
			}}else{if(MainActivity.kamoselect==11){
			level=0;
			type&=0x4;
			switch(MainActivity.mttype){
			case 3:type&=0x20000;break;
			case 2:type&=0x100000;break;
			}}else{
				type+=0x1;
				switch(MainActivity.kamoselect){
				case 1:type&=0x10;break;
				case 2:type&=0x20;break;
				case 3:type&=0x80;break;
				case 4:type&=0x40;break;
				case 5:type&=0x2000;break;
				case 9:type&=0x2000;break;
				case 6:type&=0x800000;break;
				case 7:type&=0x4000;break;
				}
				if(MainActivity.is_p){type&=0x1000000;
				level &= 0x1010000*Integer.parseInt(MainActivity.pendkd);
				desc="←"+MainActivity.pendkd+"【灵摆】"+MainActivity.pendkd+"→\n"
						+MainActivity.pendxg+"\n【怪兽描述】\n"+desc;}
				if(MainActivity.str2.contains("靈魂")){type&=0x200;}
				if(MainActivity.str2.contains("同盟")){type&=0x400;}
				if(MainActivity.str2.contains("二重")){type&=0x800;}
				if(MainActivity.str2.contains("調整")){type&=0x1000;}
				if(MainActivity.str2.contains("反轉")){type&=0x200000;}
				if(MainActivity.str2.contains("卡通")){type&=0x400000;}

				if(MainActivity.zhongz.contains("戰士")){race=0x1;}
				if(MainActivity.zhongz.contains("魔法使")){race=0x2;}
				if(MainActivity.zhongz.contains("天使")){race=0x4;}
				if(MainActivity.zhongz.contains("惡魔")){race=0x8;}
				if(MainActivity.zhongz.contains("不死")){race=0x10;}
				if(MainActivity.zhongz.contains("機械")){race=0x20;}
				if(MainActivity.zhongz.contains("水")){race=0x40;}
				if(MainActivity.zhongz.contains("炎")){race=0x80;}
				if(MainActivity.zhongz.contains("岩石")){race=0x100;}
				if(MainActivity.zhongz.contains("鳥獸")){race=0x200;}
				if(MainActivity.zhongz.contains("植物")){race=0x400;}
				if(MainActivity.zhongz.contains("昆蟲")){race=0x800;}
				if(MainActivity.zhongz.contains("雷")){race=0x1000;}
				if(MainActivity.zhongz.contains("龍")){race=0x2000;}
				if(MainActivity.zhongz.contains("獸")){race=0x4000;}
				if(MainActivity.zhongz.contains("獸戰士")){race=0x8000;}
				if(MainActivity.zhongz.contains("恐龍")){race=0x10000;}
				if(MainActivity.zhongz.contains("魚")){race=0x20000;}
				if(MainActivity.zhongz.contains("海龍")){race=0x40000;}
				if(MainActivity.zhongz.contains("爬蟲類")){race=0x80000;}
				if(MainActivity.zhongz.contains("念動力")){race=0x100000;}
				if(MainActivity.zhongz.contains("幻神獸")){race=0x200000;}
				if(MainActivity.zhongz.contains("創造神")){race=0x400000;}
				if(MainActivity.zhongz.contains("幻龍")){race=0x800000;}
				if(race==0x0){Toast.makeText(getApplicationContext(),"種族不合法。请尝试用繁体重新输入。",Toast.LENGTH_SHORT).show();}
			}}
		
		setContentView(R.layout.activity_de);
		if (savedInstanceState == null) {
/**			getSupportFragmentManager().beginTransaction()
					.add(R.id.container, new PlaceholderFragment()).commit();
*/
		}
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {


		getMenuInflater().inflate(R.menu.de, menu);
		return true;
	}

public static String name=MainActivity.str1,dexl1="",dexl2="",dexl3="",dexl4="",dbpath="",str1="",str2="",str3=""
,str4="",str5="",str6="",str7="",str8="",str9="",str10="",str11="",str12="",str13=""
,str14="",str15="",str16="",ide=MainActivity.kpmm,desc=MainActivity.xg;
public static int id=0,race=0,alias=0,i=1,setcd=0,attribute=0,level=MainActivity.level
,atk=Integer.parseInt(MainActivity.atk),def=Integer.parseInt(MainActivity.def),type=0x8&0x100&0x8000;
public static long category=0;
public boolean flag=false;
	
	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		switch(item.getItemId()){
		case R.id.dxls:
        	LayoutInflater factory=LayoutInflater.from(this);
        	final View mView=factory.inflate(R.layout.dexlog,null);
        	final EditText d0=(EditText)mView.findViewById(R.id.dxl1);
        	final EditText d1=(EditText)mView.findViewById(R.id.dxl2);
        	final EditText d2=(EditText)mView.findViewById(R.id.dxl3);
        	final EditText d3=(EditText)mView.findViewById(R.id.dxl4);
	      	d0.setText(dexl1);
        	d1.setText(dexl2);
        	d2.setText(dexl3);
        	d3.setText(dexl4);
    		AlertDialog.Builder dialog=new AlertDialog.Builder(this);
        	dialog.setView(mView)
        	.setTitle("字段(系列)").setNegativeButton("取消",null);
        	dialog.setPositiveButton("确定", new DialogInterface.OnClickListener() {
        	public void onClick(DialogInterface dialog, int which) {
        		dexl1=d0.getText().toString();
        		dexl2=d1.getText().toString();
        		dexl3=d2.getText().toString();
        		dexl4=d3.getText().toString();

        		if(dexl1.equals("")&!dexl2.equals("")){
        		dexl1=dexl2;dexl2="";}
        		if(dexl2.equals("")&!dexl3.equals("")){
        		dexl2=dexl3;dexl3="";}
        		if(dexl3.equals("")&!dexl4.equals("")){
        		dexl3=dexl4;dexl4="";}
        		
        		setcd=0;
        		dataget(dexl1);dataget(dexl2);dataget(dexl3);dataget(dexl4);
 //       		Toast.makeText(getApplicationContext(),""+setcd,Toast.LENGTH_SHORT).show();

        	}
        	});
        	dialog.show();
			
	break;
		case R.id.scrop:
        	Intent it=new Intent(this, ScriptActivity.class);
            startActivity(it);
	break;
		case R.id.dbout:
			EditText SC=(EditText)findViewById(R.id.editText2);
			try{alias=Integer.parseInt(SC.getText().toString());}catch(Exception e){alias=0;}
    		EditText SText=(EditText)findViewById(R.id.editText1);
    		String[] strr=SText.getText().toString().split("\n");
    		int i=strr.length;
    		if(i>0){str1=strr[0];}if(i>1){str2=strr[1];}if(i>2){str3=strr[2];}if(i>3){str4=strr[3];}
    		if(i>4){str5=strr[4];}if(i>5){str6=strr[5];}if(i>6){str7=strr[6];}if(i>7){str8=strr[7];}
    		if(i>8){str9=strr[8];}if(i>9){str10=strr[9];}if(i>10){str11=strr[10];}if(i>11){str12=strr[11];}
    		if(i>12){str13=strr[12];}if(i>13){str14=strr[13];}if(i>14){str15=strr[14];}if(i>15){str16=strr[15];}
    		CheckBox cb1=(CheckBox)findViewById(R.id.CheckBox1);
    		CheckBox cb2=(CheckBox)findViewById(R.id.CheckBox2);
    		CheckBox cb3=(CheckBox)findViewById(R.id.CheckBox3);
    		CheckBox cb4=(CheckBox)findViewById(R.id.CheckBox4);
    		CheckBox cb5=(CheckBox)findViewById(R.id.CheckBox5);
    		CheckBox cb6=(CheckBox)findViewById(R.id.CheckBox6);
    		CheckBox cb7=(CheckBox)findViewById(R.id.CheckBox7);
    		CheckBox cb8=(CheckBox)findViewById(R.id.CheckBox8);
    		CheckBox cb9=(CheckBox)findViewById(R.id.CheckBox9);
    		CheckBox cb10=(CheckBox)findViewById(R.id.CheckBox10);
    		CheckBox cb11=(CheckBox)findViewById(R.id.CheckBox11);
    		CheckBox cb12=(CheckBox)findViewById(R.id.CheckBox12);
    		CheckBox cb13=(CheckBox)findViewById(R.id.CheckBox13);
    		CheckBox cb14=(CheckBox)findViewById(R.id.CheckBox14);
    		CheckBox cb15=(CheckBox)findViewById(R.id.CheckBox15);
    		CheckBox cb16=(CheckBox)findViewById(R.id.CheckBox16);
    		CheckBox cb17=(CheckBox)findViewById(R.id.CheckBox17);
    		CheckBox cb18=(CheckBox)findViewById(R.id.CheckBox18);
    		CheckBox cb19=(CheckBox)findViewById(R.id.CheckBox19);
    		CheckBox cb20=(CheckBox)findViewById(R.id.CheckBox20);
    		CheckBox cb21=(CheckBox)findViewById(R.id.CheckBox21);
    		CheckBox cb22=(CheckBox)findViewById(R.id.CheckBox22);
    		CheckBox cb23=(CheckBox)findViewById(R.id.CheckBox23);
    		CheckBox cb24=(CheckBox)findViewById(R.id.CheckBox24);
    		CheckBox cb25=(CheckBox)findViewById(R.id.CheckBox25);
    		CheckBox cb26=(CheckBox)findViewById(R.id.CheckBox26);
    		CheckBox cb27=(CheckBox)findViewById(R.id.CheckBox27);
    		CheckBox cb28=(CheckBox)findViewById(R.id.checkBox28);
    		CheckBox cb29=(CheckBox)findViewById(R.id.checkBox29);
    		CheckBox cb30=(CheckBox)findViewById(R.id.checkBox30);
    		CheckBox cb31=(CheckBox)findViewById(R.id.checkBox31);
    		CheckBox cb32=(CheckBox)findViewById(R.id.checkBox32);
    		category=0;
     		if(cb1.isChecked()){category&=1L;}
    		if(cb2.isChecked()){category&=2L;}
    		if(cb3.isChecked()){category&=4L;}
    		if(cb4.isChecked()){category&=8L;}
    		if(cb5.isChecked()){category&=16L;}
    		if(cb6.isChecked()){category&=32L;}
    		if(cb7.isChecked()){category&=64L;}
    		if(cb8.isChecked()){category&=128L;}
    		if(cb9.isChecked()){category&=256L;}
    		if(cb10.isChecked()){category&=512L;}
    		if(cb11.isChecked()){category&=1024L;}
    		if(cb12.isChecked()){category&=2048L;}
    		if(cb13.isChecked()){category&=4096L;}
    		if(cb14.isChecked()){category&=8192L;}
    		if(cb15.isChecked()){category&=16384L;}
    		if(cb16.isChecked()){category&=32768L;}
    		if(cb17.isChecked()){category&=65536L;}
    		if(cb18.isChecked()){category&=131072L;}
    		if(cb19.isChecked()){category&=262144L;}
    		if(cb20.isChecked()){category&=524288L;}
    		if(cb21.isChecked()){category&=1048576L;}
    		if(cb22.isChecked()){category&=2097152L;}
    		if(cb23.isChecked()){category&=4194304L;}
    		if(cb24.isChecked()){category&=8388608L;}
    		if(cb25.isChecked()){category&=16777216L;}
    		if(cb26.isChecked()){category&=33554432L;}
    		if(cb27.isChecked()){category&=67108864L;}
    		if(cb28.isChecked()){category&=134217728L;}
    		if(cb29.isChecked()){category&=268435456L;}
    		if(cb30.isChecked()){category&=536870912L;}
    		if(cb31.isChecked()){category&=1073741824L;}
    		if(cb32.isChecked()){category&=2147483648L;}
    		
    		MainActivity.filetype=".cdb";
            showDialog(MainActivity.openfileDialogId);
	break;
		}
		return super.onOptionsItemSelected(item);
	}

	/**
	 * A placeholder fragment containing a simple view.
	 */
	public static class PlaceholderFragment extends Fragment {

		public PlaceholderFragment() {
		}

		@Override
		public View onCreateView(LayoutInflater inflater, ViewGroup container,
				Bundle savedInstanceState) {
			View rootView = inflater.inflate(R.layout.fragment_de, container,
					false);
			return rootView;
		}
	}


private void dataget(String km){
	cheack(km,"正義盟軍",1);
	cheack(km,"次世代",2);
	cheack(km,"真·次世代",4098);
	cheack(km,"盟军·次世代",8194);
	cheack(km,"亞馬遜",4);
	cheack(km,"秘儀之力",5);
	cheack(km,"暗黑界",6);
	cheack(km,"古代的機械","古代機械",7);
	cheack(km,"ＨＥＲＯ","英雄",8);
	cheack(km,"Ｅ·ＨＥＲＯ","元素英雄",12296);
	cheack(km,"Ｅ－ＨＥＲＯ","邪心英雄",24584);
	cheack(km,"Ｄ·ＨＥＲＯ","命運英雄",49160);
	cheack(km,"Ｖ·ＨＥＲＯ","幻影英雄",20488);
	cheack(km,"Ｍ·ＨＥＲＯ","假面英雄",40968);
	cheack(km,"新宇俠",9);
	cheack(km,"入魔",10);
	cheack(km,"侵入魔人",4106);
	cheack(km,"永火","無限地獄",11);
	cheack(km,"外星人",12);
	cheack(km,"劍士",13);
	cheack(km,"X-劍士",4109);
	cheack(km,"XX-劍士",12301);
	cheack(km,"電氣",14);
	cheack(km,"擾亂",15);
	cheack(km,"薰風",16);
	cheack(km,"機巧",17);
	cheack(km,"蛙",18);
	cheack(km,"機皇",19);
	cheack(km,"機皇帝",12307);
	cheack(km,"機皇兵",24595);
	cheack(km,"？？？",20);
	cheack(km,"巨大戰艦",21);
	cheack(km,"機人","小",22);
	cheack(km,"同調士",23);
	cheack(km,"雲魔物",24);
	cheack(km,"劍鬥獸",25);
	cheack(km,"黑蝎",26);
	cheack(km,"幻獸",27);
	cheack(km,"幻獸機",4123);
	cheack(km,"幻魔",28);
	cheack(km,"核成",29);
	cheack(km,"繭狀體",30);
	cheack(km,"新宇宙俠",31);
	cheack(km,"紫炎",32);
	cheack(km,"地縛神",33);
	cheack(km,"侏羅紀",34);
	cheack(km,"罪","Sin",35);
	cheack(km,"廢鐵",36);
	cheack(km,"鏈",37);
	cheack(km,"變形鬥士",38);
	cheack(km,"科技屬",39);
	cheack(km,"電池人",40);
	cheack(km,"龍騎兵團",41);
	cheack(km,"自然",42);
	cheack(km,"忍者",43);
	cheack(km,"機甲忍者",4139);
	cheack(km,"炎獄",44);
	cheack(km,"鷹身",45);
	cheack(km,"守墓",46);
	cheack(km,"冰結界",47);
	cheack(km,"大日",48);
	cheack(km,"命運女郎",49);
	cheack(km,"火山",50);
	cheack(km,"黑羽","BF",51);
	cheack(km,"寶玉獸",52);
	cheack(km,"魔轟神",53);
	cheack(km,"魔轟神獸",4149);
	cheack(km,"機甲",54);
	cheack(km,"霞之谷",55);
	cheack(km,"光道",56);
	cheack(km,"熔岩",57);
	cheack(km,"遺式",58);
	cheack(km,"真紅眼",59);
	cheack(km,"爬蟲妖女",60);
	cheack(km,"六武眾",61);
	cheack(km,"異蟲",62);
	cheack(km,"救世",63);
	cheack(km,"被封印",64);
	cheack(km,"LV",65);
	cheack(km,"極星",66);
	cheack(km,"極星天",12354);
	cheack(km,"極星獸",24642);
	cheack(km,"極星靈",41026);
	cheack(km,"極星寶",20546);
	cheack(km,"廢品",67);
	cheack(km,"代行者",68);
	cheack(km,"惡魔",69);
	cheack(km,"融合",70);
	cheack(km,"寶石",71);
	cheack(km,"寶石騎士",4167);
	cheack(km,"No.",72);
	cheack(km,"CNo.","混沌No.",4168);
	cheack(km,"銃士",73);
	cheack(km,"時攜神",74);
	cheack(km,"極神",75);
	cheack(km,"落穴",76);
	cheack(km,"進化",78);
	cheack(km,"進化蟲",12366);
	cheack(km,"進化龍",24654);
	cheack(km,"進化帝",20558);
	cheack(km,"爆裂",79);
	cheack(km,"/爆裂體",4175);
	cheack(km,"蛇毒",80);
	cheack(km,"齒輪",81);
	cheack(km,"守護者",82);
	cheack(km,"星聖",83);
	cheack(km,"我我我",84);
	cheack(km,"光子",85);
	cheack(km,"甲蟲裝機",86);
	cheack(km,"共鳴者",87);
	cheack(km,"發條",88);
	cheack(km,"隆隆隆",89);
	cheack(km,"企鵝",90);
	cheack(km,"番茄小子",91);
	cheack(km,"斯芬克斯",92);
	cheack(km,"竹光",96);
	cheack(km,"忍法",97);
	cheack(km,"卡通",98);
	cheack(km,"反應機",99);
	cheack(km,"鷹神",100);
	cheack(km,"侵略",101);
	cheack(km,"音響戰士",102);
	cheack(km,"鋼鐵",103);
	cheack(km,"鐵皮",104);
	cheack(km,"聖刻",105);
	cheack(km,"幻蝶刺客",106);
	cheack(km,"保鏢",107);
	cheack(km,"光芒使者",104);
	cheack(km,"魔人",108);
	cheack(km,"龍魔人",12397);
	cheack(km,"儀式魔人",24685);
	cheack(km,"魔導",109);
	cheack(km,"魔導書",4206);
	cheack(km,"英豪",111);
	cheack(km,"英豪挑戰者","H·C",4207);
	cheack(km,"英豪冠軍","H-C",8303);
	cheack(km,"先史遺產",112);
	cheack(km,"魔偶甜點",113);
	cheack(km,"齒輪齒輪",114);
	cheack(km,"齒輪齒輪人",4210);
	cheack(km,"超量",115);
	cheack(km,"混沌超量","CX",4211);
	cheack(km,"水精鱗",116);
	cheack(km,"深淵",117);
	cheack(km,"紋章獸",118);
	cheack(km,"海皇",119);
	cheack(km,"迅捷",120);
	cheack(km,"炎星",121);
	cheack(km,"Nobel",122);
	cheack(km,"聖騎士","NobelKnight",4218);
	cheack(km,"圣劍","NobelArms",8314);
	cheack(km,"銀河",123);
	cheack(km,"銀河眼",4219);
	cheack(km,"銀河眼時空龍",12411);
	cheack(km,"炎舞",124);
	cheack(km,"陽炎",125);
	cheack(km,"陽炎獸",4221);
	cheack(km,"ZW","異熱同心武器",126);
	cheack(km,"希望皇 霍普",127);
	cheack(km,"塵妖",128);
	cheack(km,"炎王",129);
	cheack(km,"炎王獸",4225);
	cheack(km,"怒怒怒",130);
	cheack(km,"機關傀儡",131);
	cheack(km,"燃燒拳擊手","BK",132);
	cheack(km,"超級防禦機器人",133);
	cheack(km,"光天使",134);
	cheack(km,"陰影",135);
	cheack(km,"武神",136);
	cheack(km,"武神器",4232);
	cheack(km,"洞",137);
	cheack(km,"蟲惑",138);
	cheack(km,"蟲惑魔",4234);
	cheack(km,"惡餐",139);
	cheack(km,"德魯伊",140);
	cheack(km,"鬼計",141);
	cheack(km,"吸血鬼",142);
	cheack(km,"刷拉拉",143);
	cheack(km,"森羅",144);
	cheack(km,"王家長眠之谷",145);
	cheack(km,"紋章",146);
	cheack(km,"電子",147);
	cheack(km,"電子龍",4243);
	cheack(km,"電子科技",148);
	cheack(km,"RUM","升階魔法",149);
	cheack(km,"電子魚人",150);
	cheack(km,"古遺物",151);
	cheack(km,"魔術師",152);
	cheack(km,"異色眼",153);
	cheack(km,"超重武者",154);
	cheack(km,"幻奏",155);
	cheack(km,"星因士","星輝士",156);
	cheack(km,"影依",157);
	cheack(km,"龍星",158);
	cheack(km,"娛樂夥伴","EM",159);
	cheack(km,"傳說的騎士",160);
	cheack(km,"傳說之龍",161);
	cheack(km,"黑魔術",162);
	cheack(km,"星塵",163);
	cheack(km,"羽翼栗子球",164);
	cheack(km,"變化",165);
	cheack(km,"幼芽",166);
	cheack(km,"阿托利斯",167);
	cheack(km,"蘭斯洛特",168);
	cheack(km,"毛絨動物",169);
	cheack(km,"機殼",170);
	cheack(km,"電子文具人",171);
	cheack(km,"哥布林",172);
	cheack(km,"破壞玩具",173);
	cheack(km,"契約書",174);
	cheack(km,"DD",175);
	cheack(km,"加特姆士",176);
	cheack(km,"燃燒地獄",177);
	cheack(km,"U.A",178);
	cheack(km,"妖仙獸",179);
	cheack(km,"影靈衣",180);
	cheack(km,"靈獸",181);
	cheack(km,"靈獸使",4277);
	cheack(km,"精靈獸",8373);
	cheack(km,"獄火機",182);
	cheack(km,"人造人",183);
	cheack(km,"同調士相關同調怪獸",256);
	cheack(km,"奇跡同調融合相關怪獸",257);
	cheack(km,"暗黑融合限定怪獸",258);
	cheack(km,"電子龍限定素材的融合怪獸",259);
	if(!km.equals("")&flag==false&!km.equals(MainActivity.str1+"!@#$%^&*")){
		Toast.makeText(getApplicationContext(),"有的字段不合法。请尝试用繁体重新输入。",Toast.LENGTH_SHORT).show();
	}
}

private void cheack(String string,String str,int num){
if(string.equals(MainActivity.str1+"!@#$%^&*")){
	if(string.contains(str)){
		switch(i){
			case 1:dexl1=str;i=2;break;
			case 2:dexl2=str;i=3;break;
			case 3:dexl3=str;i=4;break;
			case 4:dexl4=str;i=5;break;
			case 5:return;}}
	}
else{
		if(string.equals(str)){
			setcd &= num;
			flag = true;
		}
	}
}
private void cheack(String string,String str,String str2,int num){
if(string.equals(MainActivity.str1+"!@#$%^&*")){
	if(string.contains(str)|string.contains(str2)){
			switch(i){
				case 1:dexl1=str;i=2;break;
				case 2:dexl2=str;i=3;break;
				case 3:dexl3=str;i=4;break;
				case 4:dexl4=str;i=5;break;
				case 5:return;}}
	}
else{
		if(string.equals(str)|string.equals(str2)){
			setcd &= num;
			flag = true;
		}
		
	}

}
@Override  
protected Dialog onCreateDialog(int id) {  
    if(id==MainActivity.openfileDialogId){  
        Map<String, Integer> images = new HashMap<String, Integer>();  
        // 设置各文件类型的图标
        images.put(OpenFileDialog.sRoot, R.drawable.filedialog_root);   // 根目录图标  
        images.put(OpenFileDialog.sParent, R.drawable.filedialog_folder_up);    //返回上一层的图标  
        images.put(OpenFileDialog.sFolder, R.drawable.filedialog_folder);   //文件夹图标  
        images.put("cdb", R.drawable.filedialog_dbfile);   //set文件图标  
        images.put(OpenFileDialog.sEmpty, R.drawable.filedialog_root);  
        Dialog dialog = OpenFileDialog.createDialog(id, this, "选择card.cdb文件", new CallbackBundle() {  
            @Override  
            public void callback(Bundle bundle) {  
                dbpath = bundle.getString("path");
                final SQLiteDatabase db = SQLiteDatabase.openOrCreateDatabase(dbpath, null, 
                	    new DatabaseErrorHandler(){
                	        public void onCorruption(SQLiteDatabase dbObj) {
                	            return; }});

                AlertDialog.Builder builder = new AlertDialog.Builder(DEActivity.this);
                builder.setTitle("确认导入YGO数据库？").setIcon(android.R.drawable.ic_dialog_alert).setView(null);
                builder.setNegativeButton("确认", new DialogInterface.OnClickListener() {
                	public void onClick(DialogInterface dialog, int which) {
                        try{
                        db.execSQL("INSERT INTO datas(id,ot,alias,setcode,type,atk,def,level,race,attribute,category)VALUES(?,?,?,?,?,?,?,?,?,?,?)"
                        		,new Object[]{DEActivity.id,4,DEActivity.alias,DEActivity.setcd,DEActivity.type,DEActivity.atk
                        				,DEActivity.def,DEActivity.level,DEActivity.race,DEActivity.attribute,DEActivity.category});
                        db.execSQL("INSERT INTO texts(id,name,desc,str1,str2,str3,str4,str5,str6,str7,str8,str9,str10,str11,str12,str13,str14,str15,str16)VALUES(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)"
                        		,new Object[]{DEActivity.id,DEActivity.name,DEActivity.desc,DEActivity.str1,DEActivity.str2
                        				,DEActivity.str3,DEActivity.str4,DEActivity.str5,DEActivity.str6,DEActivity.str7
                        				,DEActivity.str8,DEActivity.str9,DEActivity.str10,DEActivity.str11,DEActivity.str12
                        				,DEActivity.str13,DEActivity.str14,DEActivity.str15,DEActivity.str16});	
                        db.close();
                        Toast.makeText(getApplicationContext(),"成功写入数据库！",Toast.LENGTH_SHORT).show();}
                        catch(Exception e){Toast.makeText(getApplicationContext(),"出错！请尝试更换数据库种类选择",Toast.LENGTH_SHORT).show();}
                      }
                });
                builder.setPositiveButton("取消",null);
	/**			new DialogInterface.OnClickListener() {
                	public void onClick(DialogInterface dialog, int which) {
                       try{
                            db.execSQL("INSERT INTO datas(_id,ot,alias,setcode,type,atk,def,level,race,attribute,category)VALUES(?,?,?,?,?,?,?,?,?,?,?)"
                            		,new Object[]{DEActivity.id,4,DEActivity.alias,DEActivity.setcd,DEActivity.type,DEActivity.atk
                            				,DEActivity.def,DEActivity.level,DEActivity.race,DEActivity.attribute,DEActivity.category});
                            db.execSQL("INSERT INTO texts(_id,name,desc,str1,str2,str3,str4,str5,str6,str7,str8,str9,str10,str11,str12,str13,str14,str15,str16)VALUES(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)"
                            		,new Object[]{DEActivity.id,DEActivity.name,DEActivity.desc,DEActivity.str1,DEActivity.str2
                            				,DEActivity.str3,DEActivity.str4,DEActivity.str5,DEActivity.str6,DEActivity.str7
                            				,DEActivity.str8,DEActivity.str9,DEActivity.str10,DEActivity.str11,DEActivity.str12
                            				,DEActivity.str13,DEActivity.str14,DEActivity.str15,DEActivity.str16});	
                            db.close();
                            Toast.makeText(getApplicationContext(),"成功写入数据库！",Toast.LENGTH_SHORT).show();}
                            catch(Exception e){Toast.makeText(getApplicationContext(),"出错！请尝试更换数据库种类选择",Toast.LENGTH_SHORT).show();}
                      }
                });
*/
                builder.show();
            }
        },
        ".cdb;",  
        images);  
        return dialog;  
    }  
    return null;  
}  


}
