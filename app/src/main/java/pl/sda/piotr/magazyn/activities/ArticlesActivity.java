package pl.sda.piotr.magazyn.activities;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;

import java.util.List;

import pl.sda.piotr.magazyn.R;
import pl.sda.piotr.magazyn.data.beams.Article;
import pl.sda.piotr.magazyn.data.stores.IStore;
import pl.sda.piotr.magazyn.data.stores.StoreFactory;
import pl.sda.piotr.magazyn.views.adapters.ArticlesAdapter;

public class ArticlesActivity extends UpdatableActivity {
    private ListView listView;
    private ArticlesAdapter listAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list);

        listView = (ListView) findViewById(R.id.list);
        listAdapter = new ArticlesAdapter(getApplicationContext(), this);
        listView.setAdapter(listAdapter);

        Button add = (Button) findViewById(R.id.add);
        add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(getApplicationContext(), ArticleActivity.class));
            }
        });
    }

    @Override
    protected void onStart() {
        super.onStart();

        update();
    }

    @Override
    public void update() {
        IStore<Article> store = StoreFactory.createArticlesStore(StoreFactory.createCategoriesStore(), StoreFactory.createProvidersStore());
        List<Article> articles = store.get();

        listAdapter.update(articles);
    }
}
