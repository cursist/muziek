insert into artiesten
        (naam)
    values
        ('AC/DC');

insert into albums
        (artiestid, naam)
    values
        ((select id from artiesten where naam = 'AC/DC'), 'Black Ice');

insert into tracks
        (albumid, naam, tijd)
    values
        ((select id from albums where naam = 'Black Ice'), 'Spoilin\' for a Fight', 181),
        ((select id from albums where naam = 'Black Ice'), 'Wheels', 210);