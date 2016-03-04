package blen.slidingdelete.Adapter;

/**
 * Created by Blensmile on 2016/2/22.
 */
//public class ContactsAdapter extends ArrayAdapter {
//    private  int mResourceID;
//    private Context context;
//    private ArrayList<ContactsBean> list;
//
//    public ContactsAdapter(Context context, int resource, ArrayList<ContactsBean> list) {
//        super(context, resource, list);
//        this.mResourceID = resource;
//        this.context = context;
//        this.list = list;
//    }
//
//    @Override
//    public View getView(int position, View convertView, ViewGroup parent) {
//        if(convertView == null){
//            convertView = View.inflate(context,mResourceID,null);
//        }
//        ImageView head = (ImageView) convertView.findViewById(R.id.head_iv);
//        TextView name = (TextView) convertView.findViewById(R.id.name_tv);
//        TextView delete = (TextView) convertView.findViewById(R.id.tv_delete);
//
//        head.setImageResource(list.get(position).icon);
//        name.setText(list.get(position).name);
//        //以下方法明显不行
//        delete.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//               getContext().remo
////                ExplosionField explosionField = new ExplosionField(context,new VerticalAscentFactory());
//////                explosionField.addListener(view);
////                explosionField.explode(v);
////               //监听结束
////                explosionField.setOnExplosionAnimationEnd(new ExplosionField.OnExplosionAnimationEnd() {
////                    @Override
////                    public void onExplosionAnimationEnd() {
////                        adapter.remove(list.get(position));
////                    }
////                });
//            }
//        });
//
//
//        return convertView;
//    }
//}
