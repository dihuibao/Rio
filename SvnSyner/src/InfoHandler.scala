

/**
 * Created by dihuibao on 26/10/14.
 */
class InfoHandler extends ISVNInfoHandler {
  override def handleInfo(info: SVNInfo): Unit = {
    println( "-----------------INFO-----------------" )
    println( "Local Path: " + info.getFile.getPath )
    println( "URL: " + info.getURL )

    if ( info.isRemote( ) && info.getRepositoryRootURL( ) != null ) {
      System.out.println( "Repository Root URL: " + info.getRepositoryRootURL( ) );
    }

    if ( info.getRepositoryUUID( ) != null ) {
      System.out.println( "Repository UUID: " + info.getRepositoryUUID( ) );
    }

    System.out.println( "Revision: " + info.getRevision( ).getNumber( ) );
    System.out.println( "Node Kind: " + info.getKind( ).toString( ) );

    System.out.println( "Last Changed Author: " + info.getAuthor( ) );
    System.out.println( "Last Changed Revision: " + info.getCommittedRevision( ).getNumber( ) );
    System.out.println( "Last Changed Date: " + info.getCommittedDate( ) );

    if ( info.getPropTime( ) != null ) {
      System.out.println( "Properties Last Updated: " + info.getPropTime( ) );
    }

    if ( info.getKind( ) == SVNNodeKind.FILE && info.getChecksum( ) != null ) {
      if ( info.getTextTime( ) != null ) {
        System.out.println( "Text Last Updated: " + info.getTextTime( ) );
      }
      System.out.println( "Checksum: " + info.getChecksum( ) );
    }

    if ( info.getLock( ) != null ) {
      if ( info.getLock( ).getID( ) != null ) {
        System.out.println( "Lock Token: " + info.getLock( ).getID( ) );
      }

      System.out.println( "Lock Owner: " + info.getLock( ).getOwner( ) );
      System.out.println( "Lock Created: " + info.getLock( ).getCreationDate( ) );

      if ( info.getLock( ).getExpirationDate( ) != null ) {
        System.out.println( "Lock Expires: " + info.getLock( ).getExpirationDate( ) );
      }

      if ( info.getLock( ).getComment( ) != null ) {
        System.out.println( "Lock Comment: " + info.getLock( ).getComment( ) );
      }
    }
  }
}
