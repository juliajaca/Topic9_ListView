package com.example.topic9_listview;

import androidx.appcompat.app.AppCompatActivity;

import android.app.ListActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

public class MainActivity extends ListActivity {
    private TextView selection;
    private static final String[] items={"lorem", "ipsum", "dolor",
            "sit", "amet",
            "consectetuer", "adipiscing", "elit", "morbi", "vel",
            "ligula", "vitae", "arcu", "aliquet", "mollis",
            "etiam", "vel", "erat", "placerat", "ante",
            "porttitor", "sodales", "pellentesque", "augue", "purus"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setListAdapter(new IconicAdapter());
        selection=(TextView)findViewById(R.id.selection);
    }

    public void onListItemClick(ListView parent, View v, int position, long id) {
        selection.setText(items[position]);
    }

    //// CLASS ICONIC ADAPTER
    class IconicAdapter extends ArrayAdapter<String> {
        IconicAdapter() {
            super(MainActivity.this, R.layout.row, R.id.textView_name, items);
        }

        //HOLDER
        public View getView(int position, View convertView, ViewGroup parent) {
            View row=super.getView(position, convertView, parent);
            ViewHolder holder = (ViewHolder)row.getTag();

            if(holder == null){
                holder = new ViewHolder(row);
                row.setTag(holder);
            }

            if (items[position].length()>4) {
                holder.icon.setImageResource(R.drawable.ic_baseline_clear_24);
            }
            else {
                holder.icon.setImageResource(R.drawable.ic_baseline_check_24);
            }
            return(row);
        }

        public View getViewOld(int position, View convertView, ViewGroup parent) {
            //View row=super.getView(position, convertView, parent);
            //ImageView icon=(ImageView)row.findViewById(R.id.imageView_poster);

            //with inflater
            //LayoutInflater inflater = getLayoutInflater();
            //View row = inflater.inflate(R.layout.row, parent, false);

            //with convertview --> si la vista no es null no se crea de nuevo, solo se modifica
            View row = convertView;

            if(row == null){
                LayoutInflater inflater = getLayoutInflater();
                row = inflater.inflate(R.layout.row, parent, false);
            }

            TextView label = (TextView) row.findViewById(R.id.textView_name);
            label.setText(items[position]);
            ImageView icon=(ImageView)row.findViewById(R.id.imageView_poster);

            if (items[position].length()>4) {
                icon.setImageResource(R.drawable.ic_baseline_clear_24);
            }
            else {
                icon.setImageResource(R.drawable.ic_baseline_check_24);
            }
            return(row);
        }
    }

}