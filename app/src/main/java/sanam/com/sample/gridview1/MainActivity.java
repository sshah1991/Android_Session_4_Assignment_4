package sanam.com.sample.gridview1;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private GridView gridView;
    private ImageView imageView;
    private TextView textview;
    private ArrayList<Integer> androidimageview;
    private ArrayList<String> androidtextview;
    private Myadapter myadapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        textview = (TextView) findViewById(R.id.text_view);
        imageView = (ImageView) findViewById(R.id.image_view);
        gridView = (GridView) findViewById(R.id.Grid_view);


        androidimageview = new ArrayList<>();
        androidimageview.add(R.drawable.gingerbread);
        androidimageview.add(R.drawable.honeycomb);
        androidimageview.add(R.drawable.icecreamsandwich);
        androidimageview.add(R.drawable.jellybean);
        androidimageview.add(R.drawable.kitkat);
        androidimageview.add(R.drawable.lollipop);

        androidtextview=new ArrayList<>();
        androidtextview.add("GINGERBREAD");
        androidtextview.add("HONEYCOMB");
        androidtextview.add("ICECREAM SANDWICH");
        androidtextview.add("JELLYBEAN");
        androidtextview.add("KITKAT");
        androidtextview.add("LOLLIPOP");

        myadapter = new Myadapter();
        gridView.setAdapter(myadapter);


    }

    public class Myadapter extends BaseAdapter {

        @Override
        public int getCount() {
            return androidimageview.size();
        }

        @Override
        public Object getItem(int i) {
            return null;
        }

        @Override
        public long getItemId(int i) {
            return 0;
        }

        @Override
        public View getView(int position, View ConvertView, ViewGroup parent) {
            viewholder holder;
            if (ConvertView == null){
                ConvertView = getLayoutInflater().inflate(R.layout.row_view,parent,false);
                holder = new viewholder();
                holder.bindView(ConvertView);
                ConvertView.setTag(holder);
                Log.e("Mainactivity","convertview is null");
            }
            else
            {
                holder = (viewholder)ConvertView.getTag();

            }
            holder.textView.setText(androidtextview.get(position));
            holder.imageView.setImageResource(androidimageview.get(position));
            return ConvertView;
        }


    }
    public class viewholder {
        ImageView imageView;
        TextView textView;

        void bindView(View convertView) {
            Log.e("MainActivity", "convertview is not null");
            imageView = (ImageView) convertView.findViewById(R.id.image_view);
            textView = (TextView) convertView.findViewById(R.id.text_view);



        }
    }
}
