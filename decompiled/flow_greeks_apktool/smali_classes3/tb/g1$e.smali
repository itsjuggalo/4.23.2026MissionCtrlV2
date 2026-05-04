.class public final Ltb/g1$e;
.super Lrb/r0$j;
.source "r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7"


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Ltb/g1;->F0(Ljava/lang/Throwable;)V
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x11
    name = "e"
.end annotation


# instance fields
.field public final a:Lrb/r0$f;

.field public final synthetic b:Ljava/lang/Throwable;

.field public final synthetic c:Ltb/g1;


# direct methods
.method public constructor <init>(Ltb/g1;Ljava/lang/Throwable;)V
    .locals 1

    .line 1
    iput-object p1, p0, Ltb/g1$e;->c:Ltb/g1;

    .line 2
    .line 3
    iput-object p2, p0, Ltb/g1$e;->b:Ljava/lang/Throwable;

    .line 4
    .line 5
    invoke-direct {p0}, Lrb/r0$j;-><init>()V

    .line 6
    .line 7
    .line 8
    sget-object p1, Lrb/k1;->s:Lrb/k1;

    .line 9
    .line 10
    const-string v0, "Panic! This is a bug!"

    .line 11
    .line 12
    invoke-virtual {p1, v0}, Lrb/k1;->r(Ljava/lang/String;)Lrb/k1;

    .line 13
    .line 14
    .line 15
    move-result-object p1

    .line 16
    invoke-virtual {p1, p2}, Lrb/k1;->q(Ljava/lang/Throwable;)Lrb/k1;

    .line 17
    .line 18
    .line 19
    move-result-object p1

    .line 20
    invoke-static {p1}, Lrb/r0$f;->e(Lrb/k1;)Lrb/r0$f;

    .line 21
    .line 22
    .line 23
    move-result-object p1

    .line 24
    iput-object p1, p0, Ltb/g1$e;->a:Lrb/r0$f;

    .line 25
    .line 26
    return-void
    .line 27
    .line 28
    .line 29
    .line 30
    .line 31
    .line 32
    .line 33
    .line 34
    .line 35
    .line 36
    .line 37
    .line 38
    .line 39
    .line 40
    .line 41
    .line 42
    .line 43
    .line 44
    .line 45
    .line 46
    .line 47
    .line 48
.end method


# virtual methods
.method public a(Lrb/r0$g;)Lrb/r0$f;
    .locals 0

    .line 1
    iget-object p1, p0, Ltb/g1$e;->a:Lrb/r0$f;

    .line 2
    .line 3
    return-object p1
    .line 4
    .line 5
    .line 6
    .line 7
    .line 8
    .line 9
    .line 10
    .line 11
    .line 12
    .line 13
    .line 14
    .line 15
    .line 16
    .line 17
    .line 18
    .line 19
    .line 20
    .line 21
    .line 22
    .line 23
    .line 24
    .line 25
    .line 26
.end method

.method public toString()Ljava/lang/String;
    .locals 3

    .line 1
    const-class v0, Ltb/g1$e;

    .line 2
    .line 3
    invoke-static {v0}, Lp6/h;->a(Ljava/lang/Class;)Lp6/h$b;

    .line 4
    .line 5
    .line 6
    move-result-object v0

    .line 7
    const-string v1, "panicPickResult"

    .line 8
    .line 9
    iget-object v2, p0, Ltb/g1$e;->a:Lrb/r0$f;

    .line 10
    .line 11
    invoke-virtual {v0, v1, v2}, Lp6/h$b;->d(Ljava/lang/String;Ljava/lang/Object;)Lp6/h$b;

    .line 12
    .line 13
    .line 14
    move-result-object v0

    .line 15
    invoke-virtual {v0}, Lp6/h$b;->toString()Ljava/lang/String;

    .line 16
    .line 17
    .line 18
    move-result-object v0

    .line 19
    return-object v0
.end method
