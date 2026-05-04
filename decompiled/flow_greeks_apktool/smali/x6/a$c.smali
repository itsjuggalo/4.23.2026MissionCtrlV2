.class public Lx6/a$c;
.super Ljava/lang/Object;
.source "r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lx6/a;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x9
    name = "c"
.end annotation


# instance fields
.field public final a:Lx6/a$d;

.field public final b:[J


# direct methods
.method public constructor <init>()V
    .locals 2

    .line 1
    new-instance v0, Lx6/a$d;

    invoke-direct {v0}, Lx6/a$d;-><init>()V

    const/16 v1, 0xa

    new-array v1, v1, [J

    invoke-direct {p0, v0, v1}, Lx6/a$c;-><init>(Lx6/a$d;[J)V

    return-void
.end method

.method public constructor <init>(Lx6/a$c;)V
    .locals 2

    .line 5
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 6
    new-instance v0, Lx6/a$d;

    iget-object v1, p1, Lx6/a$c;->a:Lx6/a$d;

    invoke-direct {v0, v1}, Lx6/a$d;-><init>(Lx6/a$d;)V

    iput-object v0, p0, Lx6/a$c;->a:Lx6/a$d;

    .line 7
    iget-object p1, p1, Lx6/a$c;->b:[J

    const/16 v0, 0xa

    invoke-static {p1, v0}, Ljava/util/Arrays;->copyOf([JI)[J

    move-result-object p1

    iput-object p1, p0, Lx6/a$c;->b:[J

    return-void
.end method

.method public constructor <init>(Lx6/a$d;[J)V
    .locals 0

    .line 2
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 3
    iput-object p1, p0, Lx6/a$c;->a:Lx6/a$d;

    .line 4
    iput-object p2, p0, Lx6/a$c;->b:[J

    return-void
.end method
