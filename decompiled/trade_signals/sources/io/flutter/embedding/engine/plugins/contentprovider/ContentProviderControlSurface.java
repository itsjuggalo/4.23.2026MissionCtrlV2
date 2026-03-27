package io.flutter.embedding.engine.plugins.contentprovider;

import android.content.ContentProvider;
import androidx.lifecycle.AbstractC1157i;

/* JADX INFO: loaded from: classes.dex */
public interface ContentProviderControlSurface {
    void attachToContentProvider(ContentProvider contentProvider, AbstractC1157i abstractC1157i);

    void detachFromContentProvider();
}
