package pl.sda.piotr.magazyn.views.adapters;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;

import java.util.List;

import pl.sda.piotr.magazyn.activities.UpdatableActivity;
import pl.sda.piotr.magazyn.data.beams.Article;
import pl.sda.piotr.magazyn.views.ArticleItem;


public class ArticlesAdapter extends ArrayAdapter<Article> {
    private UpdatableActivity activity;

    public ArticlesAdapter(Context context, UpdatableActivity activity) {
        super(context, 0);
        this.activity = activity;
    }

    public void update(List<Article> articles) {
        clear();

        addAll(articles);
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        Article article = getItem(position);

        return new ArticleItem(getContext(), article, this.activity);
    }
}
