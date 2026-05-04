package com.amazon.c.a.a;

import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.apache.commons.lang3.builder.ReflectionToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes.dex */
public class e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final String f4763a = String.format("A valid instance of %s is required to have at least one non-blank ID, either developerId or certificateId, and at least one non-blank name, either developerName or commonName.", e.class.getSimpleName());

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final String f4764b = String.format("A valid instance of %s is required to have a certificate ID.", e.class.getSimpleName());

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private String f4765c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private String f4766d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private String f4767e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private String f4768f;

    public static String a() {
        return f4763a;
    }

    public static String b() {
        return f4764b;
    }

    public boolean c() {
        return (StringUtils.isBlank(e()) || StringUtils.isBlank(f())) ? false : true;
    }

    public boolean d() {
        return !StringUtils.isBlank(e());
    }

    public String e() {
        return StringUtils.isBlank(this.f4767e) ? this.f4765c : this.f4767e;
    }

    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (obj == this) {
            return true;
        }
        if (obj.getClass() != getClass()) {
            return false;
        }
        e eVar = (e) obj;
        return new EqualsBuilder().append(this.f4767e, eVar.f4767e).append(this.f4768f, eVar.f4768f).append(this.f4765c, eVar.f4765c).append(this.f4766d, eVar.f4766d).isEquals();
    }

    public String f() {
        return StringUtils.isBlank(this.f4768f) ? this.f4766d : this.f4768f;
    }

    public String g() {
        return this.f4765c;
    }

    public String h() {
        return this.f4766d;
    }

    public int hashCode() {
        return new HashCodeBuilder().append(this.f4767e).append(this.f4768f).append(this.f4765c).append(this.f4766d).toHashCode();
    }

    public String i() {
        return this.f4767e;
    }

    public String j() {
        return this.f4768f;
    }

    public String toString() {
        return ReflectionToStringBuilder.toString(this, ToStringStyle.SHORT_PREFIX_STYLE);
    }

    public e a(String str) {
        this.f4765c = str;
        return this;
    }

    public void b(String str) {
        this.f4765c = str;
    }

    public e c(String str) {
        this.f4766d = str;
        return this;
    }

    public void d(String str) {
        this.f4766d = str;
    }

    public e g(String str) {
        this.f4768f = str;
        return this;
    }

    public void h(String str) {
        this.f4768f = str;
    }

    public e e(String str) {
        this.f4767e = str;
        return this;
    }

    public void f(String str) {
        this.f4767e = str;
    }
}
