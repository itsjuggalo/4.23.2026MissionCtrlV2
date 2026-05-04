.class public Lrb/j$b;
.super Lrb/d;
.source "r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lrb/j;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x9
    name = "b"
.end annotation


# instance fields
.field public final a:Lrb/d;

.field public final b:Lrb/h;


# direct methods
.method public constructor <init>(Lrb/d;Lrb/h;)V
    .locals 0

    .line 2
    invoke-direct {p0}, Lrb/d;-><init>()V

    .line 3
    iput-object p1, p0, Lrb/j$b;->a:Lrb/d;

    .line 4
    const-string p1, "interceptor"

    invoke-static {p2, p1}, Lp6/n;->o(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object p1

    check-cast p1, Lrb/h;

    iput-object p1, p0, Lrb/j$b;->b:Lrb/h;

    return-void
.end method

.method public synthetic constructor <init>(Lrb/d;Lrb/h;Lrb/i;)V
    .locals 0

    .line 1
    invoke-direct {p0, p1, p2}, Lrb/j$b;-><init>(Lrb/d;Lrb/h;)V

    return-void
.end method


# virtual methods
.method public a()Ljava/lang/String;
    .locals 1

    .line 1
    iget-object v0, p0, Lrb/j$b;->a:Lrb/d;

    .line 2
    .line 3
    invoke-virtual {v0}, Lrb/d;->a()Ljava/lang/String;

    .line 4
    .line 5
    .line 6
    move-result-object v0

    .line 7
    return-object v0
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
.end method

.method public e(Lrb/z0;Lrb/c;)Lrb/g;
    .locals 2

    .line 1
    iget-object v0, p0, Lrb/j$b;->b:Lrb/h;

    .line 2
    .line 3
    iget-object v1, p0, Lrb/j$b;->a:Lrb/d;

    .line 4
    .line 5
    invoke-interface {v0, p1, p2, v1}, Lrb/h;->a(Lrb/z0;Lrb/c;Lrb/d;)Lrb/g;

    .line 6
    .line 7
    .line 8
    move-result-object p1

    .line 9
    return-object p1
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
