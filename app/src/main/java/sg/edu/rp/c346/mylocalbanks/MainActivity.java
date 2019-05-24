package sg.edu.rp.c346.mylocalbanks;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    TextView tvDBS;
    TextView tvOCBC;
    TextView tvUOB;
    int mode = 0;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tvDBS = findViewById(R.id.tvDBS);
        tvOCBC = findViewById(R.id.tvOCBC);
        tvUOB = findViewById(R.id.tvUOB);

        registerForContextMenu(tvDBS);
        registerForContextMenu(tvOCBC);
        registerForContextMenu(tvUOB);
    }

    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
        super.onCreateContextMenu(menu, v, menuInfo);
        //Assign different to number(mode)
        if (v.getId() == R.id.tvDBS) {
            mode = 1;
        } else if (v.getId() == R.id.tvOCBC) {
            mode = 2;
        } else if (v.getId() == R.id.tvUOB) {
            mode = 3;
        }

    }

    @Override
    public boolean onContextItemSelected(MenuItem item) {
        int id = item.getItemId();

        if (mode == 1) {
            //link to menu_main
            if (id == R.id.website) {
                Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.dbs.com.sg"));
                startActivity(intent);
            } else if (id == R.id.contact) {
                Intent intentCall = new Intent(Intent.ACTION_DIAL, Uri.parse("tel:" + 180011+11111));
                startActivity(intentCall);
            }
        } else if (mode == 2) {
            if (id == R.id.website) {
                Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.ocbc.com"));
                startActivity(intent);
            } else if (id == R.id.contact) {
                Intent intentCall = new Intent(Intent.ACTION_DIAL, Uri.parse("tel:" + 180036+33333));
                startActivity(intentCall);
            }
        } else if (mode == 3) {
            if (id == R.id.website) {
                Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.uob.com.sg"));
                startActivity(intent);
            } else if (id == R.id.contact) {
                Intent intentCall = new Intent(Intent.ACTION_DIAL, Uri.parse("tel:" + 1800222+2121));
                startActivity(intentCall);
            }


        }
        return true;
    }



    @Override
    public boolean onCreateOptionsMenu (Menu menu){
        menu.add(0, 0, 0 ,"English");
        menu.add(0,1,1,"Chinese");
        return true;

    }

    @Override
    public boolean onOptionsItemSelected (MenuItem item){
        int id = item.getItemId();

        if(id == 0){
            tvDBS.setText("DBS");
            tvOCBC.setText("OCBC");
            tvUOB.setText("UOB");
        }else if(id == 1){
            tvDBS.setText("星华银行");
            tvOCBC.setText("华侨银行");
            tvUOB.setText("大华银行");
        }

        return true;
    }
}
