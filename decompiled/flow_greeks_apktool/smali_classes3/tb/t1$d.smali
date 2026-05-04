.class public final Ltb/t1$d;
.super Lrb/r0$j;
.source "r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Ltb/t1;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x19
    name = "d"
.end annotation


# instance fields
.field public final a:Lrb/r0$f;


# direct methods
.method public constructor <init>(Lrb/r0$f;)V
    .locals 1

    .line 1
    invoke-direct {p0}, Lrb/r0$j;-><init>()V

    .line 2
    .line 3
    .line 4
    const-string v0, "result"

    .line 5
    .line 6
    invoke-static {p1, v0}, Lp6/n;->o(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 7
    .line 8
    .line 9
    move-result-object p1

    .line 10
    check-cast p1, Lrb/r0$f;

    .line 11
    .line 12
    iput-object p1, p0, Ltb/t1$d;->a:Lrb/r0$f;

    .line 13
    .line 14
    return-void
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


# virtual methods
.method public a(Lrb/r0$g;)Lrb/r0$f;
    .locals 0

    .line 1
    iget-object p1, p0, Ltb/t1$d;->a:Lrb/r0$f;

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
    const-class v0, Ltb/t1$d;

    .line 2
    .line 3
    invoke-static {v0}, Lp6/h;->a(Ljava/lang/Class;)Lp6/h$b;

    .line 4
    .line 5
    .line 6
    move-result-object v0

    .line 7
    const-string v1, "result"

    .line 8
    .line 9
    iget-object v2, p0, Ltb/t1$d;->a:Lrb/r0$f;

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
