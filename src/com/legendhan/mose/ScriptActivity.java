package com.legendhan.mose;

import android.app.*;
import android.content.*;
import android.os.*;
import android.support.v4.app.*;
import android.view.*;
import android.widget.*;
import java.io.*;
import java.util.*;

import android.support.v4.app.Fragment;

public class ScriptActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_script);
		EditText ET=(EditText)findViewById(R.id.scredit);
		ET.setText(MainActivity.cardscript);
		
/**		if (savedInstanceState == null) {
			getSupportFragmentManager().beginTransaction()
					.add(R.id.container, new Fragment()).commit();
		}
*/
	}

private String luapath="";

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {

		getMenuInflater().inflate(R.menu.script, menu);
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		// Handle action bar item clicks here. The action bar will
		// automatically handle clicks on the Home/Up button, so long
		// as you specify a parent activity in AndroidManifest.xml.
		switch(item.getItemId()){

		case R.id.scrout:
			EditText ET=(EditText)findViewById(R.id.scredit);
			MainActivity.cardscript=ET.getText().toString();
			Strout(MainActivity.cardscript);
			
	break;
	
		case R.id.scread:
			MainActivity.filetype=".lua";
            showDialog(MainActivity.openfileDialogId);
			
	break;
	
		case R.id.dexop:
        	if(MainActivity.kpmm.equals("00000000")){
			Toast.makeText(getApplicationContext(),"��Ƭ���벻��ȫΪ0����",Toast.LENGTH_SHORT).show();}
        	else{Intent it=new Intent(this, DEActivity.class);
            startActivity(it);}
	break;
			default:
				return super.onOptionsItemSelected(item);
		}
		return true;
	}

private boolean Strout(String str){
	str.replaceAll("“", "\"");
	str.replaceAll("”", "\"");
	str.replaceAll("；", ";");
	str.replaceAll("。", ".");
	str.replaceAll("，", ",");
	str.replaceAll("（", "(");
	str.replaceAll("）", ")");
	str.replaceAll("‘", "\'");
	str.replaceAll("’", "\'");
	str.replaceAll("？", "?");
	String cc=MainActivity.kpmm;
	if(cc.equals("00000000")){
		Toast.makeText(getApplicationContext(),"��Ƭ���벻��ȫΪ0����",Toast.LENGTH_SHORT).show();
		return false;}
	while(cc.substring(0, 1).equals("0")){cc=cc.replaceFirst("0", "");}
	try {
		FileWriter fw = new FileWriter(MainActivity.scriptpath+"c"+cc+".lua");
		fw.flush();
		fw.write(str);
		fw.close();
		Toast.makeText(getApplicationContext(),"�ѱ���"+MainActivity.scriptpath+"c"+cc+".lua",Toast.LENGTH_SHORT).show();
		return true;
	} catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
		return false; 
	}	
}

@Override  
protected Dialog onCreateDialog(int id) {  
    if(id==MainActivity.openfileDialogId){  
        Map<String, Integer> images = new HashMap<String, Integer>();  
        // ���ø��ļ����͵�ͼ��
        images.put(OpenFileDialog.sRoot, R.drawable.filedialog_root);   // ��Ŀ¼ͼ��  
        images.put(OpenFileDialog.sParent, R.drawable.filedialog_folder_up);    //������һ���ͼ��  
        images.put(OpenFileDialog.sFolder, R.drawable.filedialog_folder);   //�ļ���ͼ��  
        images.put("lua", R.drawable.filedialog_luafile);   //set�ļ�ͼ��  
        images.put(OpenFileDialog.sEmpty, R.drawable.filedialog_root);  
        Dialog dialog = OpenFileDialog.createDialog(id, this, "ѡ��lua�ű��ļ�", new CallbackBundle() {  
            @Override  
            public void callback(Bundle bundle) {
               luapath=bundle.getString("path");
               File RF=new File(luapath);
               String tempstr="",sumstr="";
               BufferedReader reader = null;
               EditText ET=(EditText)findViewById(R.id.scredit);
               try {
                   InputStreamReader isr = new InputStreamReader(new FileInputStream(RF), "UTF-8");
                   reader = new BufferedReader(isr);
                   while((tempstr=reader.readLine())!=null){
                	   sumstr += tempstr+"\r\n";
                   }
                   reader.close();
                   ET.setText(sumstr);
               } catch (IOException e) {
               	Toast.makeText(getApplicationContext(),"����������",Toast.LENGTH_SHORT).show();
                   e.printStackTrace();
               } finally {
                   if (reader != null) {
                       try {
                           reader.close();
                       } catch (IOException e1) {
                       	Toast.makeText(getApplicationContext(),"����������",Toast.LENGTH_SHORT).show();
                       }
                   }
               }
               
            }
        },
        ".lua;",  
        images);  
        return dialog;  
    }  
    return null;  
}

}

