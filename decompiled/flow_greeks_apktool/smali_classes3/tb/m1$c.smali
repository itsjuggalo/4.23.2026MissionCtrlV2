.class public Ltb/m1$c;
.super Ljava/io/OutputStream;
.source "r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Ltb/m1;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x1
    name = "c"
.end annotation


# instance fields
.field public final synthetic a:Ltb/m1;


# direct methods
.method public constructor <init>(Ltb/m1;)V
    .locals 0

    .line 1
    iput-object p1, p0, Ltb/m1$c;->a:Ltb/m1;

    invoke-direct {p0}, Ljava/io/OutputStream;-><init>()V

    return-void
.end method

.method public synthetic constructor <init>(Ltb/m1;Ltb/m1$a;)V
    .locals 0

    .line 2
    invoke-direct {p0, p1}, Ltb/m1$c;-><init>(Ltb/m1;)V

    return-void
.end method


# virtual methods
.method public write(I)V
    .locals 3

    int-to-byte p1, p1

    const/4 v0, 0x1

    .line 1
    new-array v1, v0, [B

    const/4 v2, 0x0

    aput-byte p1, v1, v2

    .line 2
    invoke-virtual {p0, v1, v2, v0}, Ltb/m1$c;->write([BII)V

    return-void
.end method

.method public write([BII)V
    .locals 1

    .line 3
    iget-object v0, p0, Ltb/m1$c;->a:Ltb/m1;

    invoke-static {v0, p1, p2, p3}, Ltb/m1;->c(Ltb/m1;[BII)V

    return-void
.end method
