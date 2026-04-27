package q5;

/* JADX INFO: loaded from: classes.dex */
public final class d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final boolean f9404a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f9405b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final String f9406c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final boolean f9407d;
    public final a e;

    public d() {
        a aVar = a.f9398a;
        this.f9404a = true;
        this.f9405b = "    ";
        this.f9406c = "type";
        this.f9407d = true;
        this.e = aVar;
    }

    public final String toString() {
        return "JsonConfiguration(encodeDefaults=false, ignoreUnknownKeys=false, isLenient=false, allowStructuredMapKeys=false, prettyPrint=false, explicitNulls=" + this.f9404a + ", prettyPrintIndent='" + this.f9405b + "', coerceInputValues=false, useArrayPolymorphism=false, classDiscriminator='" + this.f9406c + "', allowSpecialFloatingPointValues=false, useAlternativeNames=" + this.f9407d + ", namingStrategy=null, decodeEnumsCaseInsensitive=false, allowTrailingComma=false, allowComments=false, classDiscriminatorMode=" + this.e + ')';
    }
}
