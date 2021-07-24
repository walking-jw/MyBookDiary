package com.teambook.mybookdiary;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import com.google.android.material.snackbar.Snackbar;

public class BookListAdapter extends RecyclerView.Adapter<BookListAdapter.ViewHolder> {

    private Context mContext = null; //어디서 불렀는지
    private int layout = 0;
    //private ArrayList<Diary> data =null; //data
    private String[] titles = {"Monday 월", "Tuesday 화", "Wednesdat 수", "Thursday 목", "Friday 금", "Saturday 토", "Sunday 일"};
   // private LayoutInflater inflater = null ;


    //생성자
//    public ListAdapter(Context mContext, int layout, ArrayList<Diary> data) {
//        this.mContext = mContext;
//        this.layout = layout;
//        this.data = data;
           // this.inflater = (LayoutInflater) mContext.getSystemService(Context.LAYOUT_INFLATER_SERVICE);

//    }

    //------------2.ViewHolder 만들기
    //class 안에 class , 제너릭으로 ViewHolder를 부름
    public class ViewHolder extends RecyclerView.ViewHolder {

        public TextView booklist_title, booklist_writer, booklist_publisher, booklist_content;
        public ImageView booklist_image;


        public ViewHolder(View itemView) {
            super(itemView);
            booklist_title = itemView.findViewById(R.id.booklist_title);
            booklist_writer = itemView.findViewById(R.id.booklist_writer);
            booklist_publisher = itemView.findViewById(R.id.booklist_publisher);
            booklist_content = itemView.findViewById(R.id.booklist_content);
            booklist_image = itemView.findViewById(R.id.booklist_image);


            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    //뭘 클릭했는지 (현재 클릭한 위치)
                    int position = getAdapterPosition();
                    //snackbar 띄울거임
                    Snackbar.make(v,titles[position], Snackbar.LENGTH_SHORT).setAction(titles[position]+"눌렀습니다.",null).show();
                }
            });

////            아까 클리커블, 포커서블 해놨음
////            셀모양 눌렀을때? 인가봄
//            itemView.setOnClickListener(new View.OnClickListener() {
//                Intent intent = null;
//                @Override
//                public void onClick(View v) {
//                    //뭘 클릭했는지 (현재 클릭한 위치)
//                    int position = getAdapterPosition();
//                    intent.putExtra("date", data.get(position).getDate());
//                    intent.putExtra("title", data.get(position).getTitle());
//                    intent.putExtra("detail", data.get(position).getDetail());
//                    intent.putExtra("status", data.get(position).getStatus());
//                    intent = Intent(v.getContext(), DiaryUpdateActivity.class);
//
//                    //snackbar 띄울거임
//                    Snackbar.make(v,data.get(position).getTitle(), Snackbar.LENGTH_LONG).setAction("누르셨습니다.",null).show();
//                }
//            });
        }
    }

    //뷰홀더 만들기
    @Override
    public BookListAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.booklist_custom_layout, parent, false);
        ViewHolder viewHolder = new ViewHolder(v);

        return viewHolder;
    }

    @Override
    public void onBindViewHolder(BookListAdapter.ViewHolder holder, int position) {
        //배열이므로
        holder.booklist_title.setText(titles[position]);

//        holder.list_tvdate.setText(data.get(position).getDate());
//        holder.list_tvtitle.setText(data.get(position).getTitle());
//        holder.list_tvdetail.setText(data.get(position).getDetail());
//        holder.list_tvstatus.loadData(htmlData(data.get(position).getStatus()),"text/html","UTF-8");
//            Glide.with(mContext)
//                    .load(ShareVar.urlAddr + data.get(position).getDimage())
//                    .override(300,200)
//                    .centerCrop()
//                    .into(holder.booklist_image);

//        holder.itemView.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                Intent intent = new Intent(v.getContext(),DiaryUpdateActivity.class);
//                intent.putExtra("date", data.get(position).getDate());
//                intent.putExtra("title", data.get(position).getTitle());
//                intent.putExtra("detail", data.get(position).getDetail());
//                intent.putExtra("status", data.get(position).getStatus());
//                intent.setFlags(intent.FLAG_ACTIVITY_NEW_TASK);
//                v.getContext().startActivity(intent);
//            }
//        });
    }


    @Override
    public int getItemCount() {
        return titles.length;
    }

    //public int getItemCount() {
//        return data.size();
//    }


}