package com.google.firebase.firestore;

import android.app.Activity;
import com.google.firebase.firestore.util.Executors;
import com.google.firebase.firestore.util.Preconditions;
import java.util.concurrent.Executor;

/* JADX INFO: loaded from: classes.dex */
public final class SnapshotListenOptions {
    private final Activity activity;
    private final Executor executor;
    private final MetadataChanges metadataChanges;
    private final ListenSource source;

    public static class Builder {
        private MetadataChanges metadataChanges = MetadataChanges.EXCLUDE;
        private ListenSource source = ListenSource.DEFAULT;
        private Executor executor = Executors.DEFAULT_CALLBACK_EXECUTOR;
        private Activity activity = null;

        public SnapshotListenOptions build() {
            return new SnapshotListenOptions(this);
        }

        public Builder setActivity(Activity activity) {
            Preconditions.checkNotNull(activity, "activity must not be null.");
            this.activity = activity;
            return this;
        }

        public Builder setExecutor(Executor executor) {
            Preconditions.checkNotNull(executor, "executor must not be null.");
            this.executor = executor;
            return this;
        }

        public Builder setMetadataChanges(MetadataChanges metadataChanges) {
            Preconditions.checkNotNull(metadataChanges, "metadataChanges must not be null.");
            this.metadataChanges = metadataChanges;
            return this;
        }

        public Builder setSource(ListenSource listenSource) {
            Preconditions.checkNotNull(listenSource, "listen source must not be null.");
            this.source = listenSource;
            return this;
        }
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && SnapshotListenOptions.class == obj.getClass()) {
            SnapshotListenOptions snapshotListenOptions = (SnapshotListenOptions) obj;
            if (this.metadataChanges == snapshotListenOptions.metadataChanges && this.source == snapshotListenOptions.source && this.executor.equals(snapshotListenOptions.executor) && this.activity.equals(snapshotListenOptions.activity)) {
                return true;
            }
        }
        return false;
    }

    public Activity getActivity() {
        return this.activity;
    }

    public Executor getExecutor() {
        return this.executor;
    }

    public MetadataChanges getMetadataChanges() {
        return this.metadataChanges;
    }

    public ListenSource getSource() {
        return this.source;
    }

    public int hashCode() {
        int iHashCode = ((((this.metadataChanges.hashCode() * 31) + this.source.hashCode()) * 31) + this.executor.hashCode()) * 31;
        Activity activity = this.activity;
        return iHashCode + (activity != null ? activity.hashCode() : 0);
    }

    public String toString() {
        return "SnapshotListenOptions{metadataChanges=" + this.metadataChanges + ", source=" + this.source + ", executor=" + this.executor + ", activity=" + this.activity + '}';
    }

    private SnapshotListenOptions(Builder builder) {
        this.metadataChanges = builder.metadataChanges;
        this.source = builder.source;
        this.executor = builder.executor;
        this.activity = builder.activity;
    }
}
