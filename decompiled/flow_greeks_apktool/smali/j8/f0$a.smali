.class public Lj8/f0$a;
.super Lj8/f0;
.source "r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lj8/f0;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x9
    name = "a"
.end annotation


# instance fields
.field public final a:Lj8/y;

.field public final b:Lj8/l;


# direct methods
.method public constructor <init>(Lj8/y;Lj8/l;)V
    .locals 0

    .line 1
    invoke-direct {p0}, Lj8/f0;-><init>()V

    .line 2
    .line 3
    .line 4
    iput-object p1, p0, Lj8/f0$a;->a:Lj8/y;

    .line 5
    .line 6
    iput-object p2, p0, Lj8/f0$a;->b:Lj8/l;

    .line 7
    .line 8
    return-void
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
.end method


# virtual methods
.method public a(Lr8/b;)Lj8/f0;
    .locals 2

    .line 1
    iget-object v0, p0, Lj8/f0$a;->b:Lj8/l;

    .line 2
    .line 3
    invoke-virtual {v0, p1}, Lj8/l;->v(Lr8/b;)Lj8/l;

    .line 4
    .line 5
    .line 6
    move-result-object p1

    .line 7
    new-instance v0, Lj8/f0$a;

    .line 8
    .line 9
    iget-object v1, p0, Lj8/f0$a;->a:Lj8/y;

    .line 10
    .line 11
    invoke-direct {v0, v1, p1}, Lj8/f0$a;-><init>(Lj8/y;Lj8/l;)V

    .line 12
    .line 13
    .line 14
    return-object v0
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
.end method

.method public b()Lr8/n;
    .locals 3

    .line 1
    iget-object v0, p0, Lj8/f0$a;->a:Lj8/y;

    .line 2
    .line 3
    iget-object v1, p0, Lj8/f0$a;->b:Lj8/l;

    .line 4
    .line 5
    new-instance v2, Ljava/util/ArrayList;

    .line 6
    .line 7
    invoke-direct {v2}, Ljava/util/ArrayList;-><init>()V

    .line 8
    .line 9
    .line 10
    invoke-virtual {v0, v1, v2}, Lj8/y;->J(Lj8/l;Ljava/util/List;)Lr8/n;

    .line 11
    .line 12
    .line 13
    move-result-object v0

    .line 14
    return-object v0
    .line 15
    .line 16
.end method
