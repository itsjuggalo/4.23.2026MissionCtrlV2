.class public Ld9/h1$b;
.super Ljava/lang/Object;
.source "r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Ld9/h1;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x9
    name = "b"
.end annotation


# instance fields
.field public a:J


# direct methods
.method public constructor <init>()V
    .locals 2

    .line 2
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    const-wide/32 v0, 0x6400000

    .line 3
    iput-wide v0, p0, Ld9/h1$b;->a:J

    return-void
.end method

.method public synthetic constructor <init>(Ld9/h1$a;)V
    .locals 0

    .line 1
    invoke-direct {p0}, Ld9/h1$b;-><init>()V

    return-void
.end method


# virtual methods
.method public a()Ld9/h1;
    .locals 4

    .line 1
    new-instance v0, Ld9/h1;

    .line 2
    .line 3
    iget-wide v1, p0, Ld9/h1$b;->a:J

    .line 4
    .line 5
    const/4 v3, 0x0

    .line 6
    invoke-direct {v0, v1, v2, v3}, Ld9/h1;-><init>(JLd9/h1$a;)V

    .line 7
    .line 8
    .line 9
    return-object v0
    .line 10
    .line 11
    .line 12
    .line 13
    .line 14
    .line 15
    .line 16
.end method

.method public b(J)Ld9/h1$b;
    .locals 0

    .line 1
    iput-wide p1, p0, Ld9/h1$b;->a:J

    .line 2
    .line 3
    return-object p0
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
.end method
