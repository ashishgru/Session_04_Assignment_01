package ashishrpa.session_04_assignment_01;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Collections;

public class MainActivity extends AppCompatActivity {
    private ListView mListView;
    private ArrayList<String> months=new ArrayList<>();
    private Button ascButton, descButton;
    MyAdapter myAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mListView = (ListView)findViewById(R.id.monthList);
        ascButton = (Button)findViewById(R.id.ascButton);
        descButton = (Button)findViewById(R.id.descButton);


        months.add("January");
        months.add("February");
        months.add("March");
        months.add("April");
        months.add("May");
        months.add("June");
        months.add("July");
        months.add("August");
        months.add("September");
        months.add("October");
        months.add("November");
        months.add("December");

        myAdapter = new MyAdapter();
        mListView.setAdapter(myAdapter);

        ascButton.setOnClickListener(new View.OnClickListener(){
            public void onClick(View view){
                doASC();
              myAdapter.notifyDataSetChanged();
            }
        });

        descButton.setOnClickListener(new View.OnClickListener(){
            public void onClick(View view){
                doDESC();
                myAdapter.notifyDataSetChanged();
            }
        });

    }

    class MyAdapter extends BaseAdapter {

        @Override
        public int getCount() {
            return months.size();
        }

        @Override
        public Object getItem(int position) {
            return null;
        }

        @Override
        public long getItemId(int position) {
            return 0;
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            ViewHolder holder;
            if(convertView == null){
                convertView = getLayoutInflater().inflate(R.layout.month_list_item,parent,false);
                holder = new ViewHolder();
                holder.bindView(convertView);
                convertView.setTag(holder);
                Log.e("Main_ACTIVITY","convertView is NULL");
            }else{
                holder = (ViewHolder)convertView.getTag();
            }
            holder.textView1.setText(months.get(position));
            return convertView;
        }
    }

    private class ViewHolder{
        TextView textView1;

        void bindView(View convertView) {
            textView1 = (TextView)convertView.findViewById(R.id.monthTextView);
        }
    }

    public void doASC(){
        Collections.sort(this.months);
    }

    public void doDESC(){
        Collections.sort(this.months, Collections.reverseOrder());
    }
}
