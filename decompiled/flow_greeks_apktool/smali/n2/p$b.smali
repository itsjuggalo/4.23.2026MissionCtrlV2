.class public Ln2/p$b;
.super Ln2/m;
.source "r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Ln2/p;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x9
    name = "b"
.end annotation


# instance fields
.field public a:Ln2/p;


# direct methods
.method public constructor <init>(Ln2/p;)V
    .locals 0

    .line 1
    invoke-direct {p0}, Ln2/m;-><init>()V

    .line 2
    .line 3
    .line 4
    iput-object p1, p0, Ln2/p$b;->a:Ln2/p;

    .line 5
    .line 6
    return-void
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
.end method


# virtual methods
.method public b(Ln2/l;)V
    .locals 1

    .line 1
    iget-object p1, p0, Ln2/p$b;->a:Ln2/p;

    .line 2
    .line 3
    iget-boolean v0, p1, Ln2/p;->S:Z

    .line 4
    .line 5
    if-nez v0, :cond_0

    .line 6
    .line 7
    invoke-virtual {p1}, Ln2/l;->c0()V

    .line 8
    .line 9
    .line 10
    iget-object p1, p0, Ln2/p$b;->a:Ln2/p;

    .line 11
    .line 12
    const/4 v0, 0x1

    .line 13
    iput-boolean v0, p1, Ln2/p;->S:Z

    .line 14
    .line 15
    :cond_0
    return-void
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

.method public d(Ln2/l;)V
    .locals 2

    .line 1
    iget-object v0, p0, Ln2/p$b;->a:Ln2/p;

    .line 2
    .line 3
    iget v1, v0, Ln2/p;->R:I

    .line 4
    .line 5
    add-int/lit8 v1, v1, -0x1

    .line 6
    .line 7
    iput v1, v0, Ln2/p;->R:I

    .line 8
    .line 9
    if-nez v1, :cond_0

    .line 10
    .line 11
    const/4 v1, 0x0

    .line 12
    iput-boolean v1, v0, Ln2/p;->S:Z

    .line 13
    .line 14
    invoke-virtual {v0}, Ln2/l;->q()V

    .line 15
    .line 16
    .line 17
    :cond_0
    invoke-virtual {p1, p0}, Ln2/l;->R(Ln2/l$f;)Ln2/l;

    .line 18
    .line 19
    .line 20
    return-void
    .line 21
    .line 22
    .line 23
    .line 24
.end method
