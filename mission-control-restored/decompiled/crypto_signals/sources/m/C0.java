package m;

import android.R;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

/* JADX INFO: loaded from: classes.dex */
public final class C0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final TextView f8210a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final TextView f8211b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final ImageView f8212c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final ImageView f8213d;
    public final ImageView e;

    public C0(View view) {
        this.f8210a = (TextView) view.findViewById(R.id.text1);
        this.f8211b = (TextView) view.findViewById(R.id.text2);
        this.f8212c = (ImageView) view.findViewById(R.id.icon1);
        this.f8213d = (ImageView) view.findViewById(R.id.icon2);
        this.e = (ImageView) view.findViewById(com.cryptosignals.ap.android.R.id.edit_query);
    }
}
