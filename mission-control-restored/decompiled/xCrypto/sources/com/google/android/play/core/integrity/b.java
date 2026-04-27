package com.google.android.play.core.integrity;

/* JADX INFO: loaded from: classes.dex */
final class b extends bq {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private String f10121a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private y f10122b;

    @Override // com.google.android.play.core.integrity.bq
    public final bq a(y yVar) {
        this.f10122b = yVar;
        return this;
    }

    @Override // com.google.android.play.core.integrity.bq
    public final bq b(String str) {
        if (str == null) {
            throw new NullPointerException("Null token");
        }
        this.f10121a = str;
        return this;
    }

    @Override // com.google.android.play.core.integrity.bq
    public final br c() {
        y yVar;
        String str = this.f10121a;
        if (str != null && (yVar = this.f10122b) != null) {
            return new br(str, yVar);
        }
        StringBuilder sb = new StringBuilder();
        if (this.f10121a == null) {
            sb.append(" token");
        }
        if (this.f10122b == null) {
            sb.append(" integrityDialogWrapper");
        }
        throw new IllegalStateException("Missing required properties:".concat(sb.toString()));
    }
}
