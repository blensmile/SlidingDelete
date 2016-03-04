package blen.slidingdelete;

import android.content.Context;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;



import java.util.ArrayList;
import java.util.Random;

import blen.slidingdelete.Beans.ContactsBean;
import blen.slidingdelete.Explosion.ExplosionField;
import blen.slidingdelete.Explosion.factory.FlyawayFactory;
import blen.slidingdelete.Layout.SwipeLayout;


/**
 *
 */
public class MainActivity extends AppCompatActivity {
    private Context context;
    ArrayList<ContactsBean> list;
    private int[] ICON_IDs = {R.drawable.baidu_map, R.drawable.changba, R.drawable.gaode_map, R.drawable.iqiyi, R.drawable.jd, R.drawable.lm, R.drawable.qq, R.drawable.qq_music, R.drawable.qzone, R.drawable.tb, R.drawable.vx, R.drawable.wb};
    ContactsAdapter adapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        context = this;
        ListView lv_text = (ListView) findViewById(R.id.text_lv);
        list = new ArrayList<>();
        Random random = new Random();
        for(String i:Cheeses.NAMES){
            list.add(new ContactsBean(i,ICON_IDs[random.nextInt(ICON_IDs.length)]));
        }
//        final ArrayAdapter<String> adapter = new ArrayAdapter<>(this,R.layout.item_contacts,R.id.name_tv,list);
//        lv_text.setAdapter(adapter);

        adapter = new ContactsAdapter(this, R.layout.item_contacts,list);
        lv_text.setAdapter(adapter);

//        lv_text.setOnItemClickListener(new AdapterView.OnItemClickListener() {
//            @Override
//            public void onItemClick(AdapterView<?> parent, View view,final int position, long id) {
//                //这个是否可以用在listview上
//                ExplosionField explosionField = new ExplosionField(context,new VerticalAscentFactory());
////                explosionField.addListener(view);
//                explosionField.explode(view);
//               //监听结束
//                explosionField.setOnExplosionAnimationEnd(new ExplosionField.OnExplosionAnimationEnd() {
//                    @Override
//                    public void onExplosionAnimationEnd() {
//                        adapter.remove(list.get(position));
//                    }
//                });
//            }
//        });
    }

    public class ContactsAdapter extends ArrayAdapter {
        private  int mResourceID;
        private Context context;
        private ArrayList<ContactsBean> list;

        public ContactsAdapter(Context context, int resource, ArrayList<ContactsBean> list) {
            super(context, resource, list);
            this.mResourceID = resource;
            this.context = context;
            this.list = list;
        }

        @Override
        public View getView(final int position, View convertView, ViewGroup parent) {
            if(convertView == null){
                convertView = View.inflate(context,mResourceID,null);
            }

            ImageView head = (ImageView) convertView.findViewById(R.id.head_iv);
            TextView name = (TextView) convertView.findViewById(R.id.name_tv);
            TextView delete = (TextView) convertView.findViewById(R.id.tv_delete);

            head.setImageResource(list.get(position).icon);
            name.setText(list.get(position).name);


            delete.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(final View v) {
                    ExplosionField explosionField = new ExplosionField(context,new FlyawayFactory());
    //                explosionField.addListener(view);
                    //getParent返回的ViewParent可能不是View,强转可能会有问题
                    explosionField.explode((View)v.getParent().getParent());
                    ((SwipeLayout) v.getParent().getParent()).close(true);//全部复位
                   //监听结束
                    explosionField.setOnExplosionAnimationEnd(new ExplosionField.OnExplosionAnimationEnd() {
                        @Override
                        public void onExplosionAnimationEnd() {
                            adapter.remove(list.get(position));
                        }
                    });
                }
            });
            return convertView;
        }
    }
}
