

INSERT INTO korisnik (id, e_mail, korisnicko_ime, lozinka, ime, prezime, uloga)
              VALUES (1,'miroslav@maildrop.cc','miroslav','$2y$12$NH2KM2BJaBl.ik90Z1YqAOjoPgSd0ns/bF.7WedMxZ54OhWQNNnh6','Miroslav','Simic','ADMIN');
INSERT INTO korisnik (id, e_mail, korisnicko_ime, lozinka, ime, prezime, uloga)
              VALUES (2,'tamara@maildrop.cc','tamara','$2y$12$DRhCpltZygkA7EZ2WeWIbewWBjLE0KYiUO.tHDUaJNMpsHxXEw9Ky','Tamara','Milosavljevic','KORISNIK');
INSERT INTO korisnik (id, e_mail, korisnicko_ime, lozinka, ime, prezime, uloga)
              VALUES (3,'petar@maildrop.cc','petar','$2y$12$i6/mU4w0HhG8RQRXHjNCa.tG2OwGSVXb0GYUnf8MZUdeadE4voHbC','Petar','Jovic','KORISNIK');

              
INSERT INTO `test`.`reprezentacija` (`id`, `naziv`, `skraceni_naziv`) VALUES ('1', 'Srbija', 'SRB');
INSERT INTO `test`.`reprezentacija` (`id`, `naziv`, `skraceni_naziv`) VALUES ('2', 'Brazil', 'BRA');
INSERT INTO `test`.`reprezentacija` (`id`, `naziv`, `skraceni_naziv`) VALUES ('3', 'Argentina', 'ARG');
INSERT INTO `test`.`reprezentacija` (`id`, `naziv`, `skraceni_naziv`) VALUES ('4', 'Danska', 'DNK');

              
INSERT INTO `test`.`igrac` (`id`, `ime`, `postignuti_golovi`, `prezime`, `reprezentacija_id`) VALUES ('1', 'Milos', '1', 'Jovanovi', '1');
INSERT INTO `test`.`igrac` (`id`, `ime`, `postignuti_golovi`, `prezime`, `reprezentacija_id`) VALUES ('2', 'Nikola', '3', 'Milosevic', '1');
INSERT INTO `test`.`igrac` (`id`, `ime`, `postignuti_golovi`, `prezime`, `reprezentacija_id`) VALUES ('3', 'Djordje', '1', 'Nikolic', '2');
INSERT INTO `test`.`igrac` (`id`, `ime`, `postignuti_golovi`, `prezime`, `reprezentacija_id`) VALUES ('4', 'Nikola', '2', 'Petrovic', '3');
INSERT INTO `test`.`igrac` (`id`, `ime`, `postignuti_golovi`, `prezime`, `reprezentacija_id`) VALUES ('5', 'Dusan', '5', 'Vuletic', '3');
INSERT INTO `test`.`igrac` (`id`, `ime`, `postignuti_golovi`, `prezime`, `reprezentacija_id`) VALUES ('6', 'Jovan', '5', 'Krstiv', '4');


INSERT INTO `test`.`utakmica` (`id`, `broj_golovaa`, `broj_golovab`, `reprezentacijab_id`, `reprezntacijaa_id`) VALUES ('1', '3', '2', '1', '2');
INSERT INTO `test`.`utakmica` (`id`, `broj_golovaa`, `broj_golovab`, `reprezentacijab_id`, `reprezntacijaa_id`) VALUES ('2', '1', '2', '1', '3');
INSERT INTO `test`.`utakmica` (`id`, `broj_golovaa`, `broj_golovab`, `reprezentacijab_id`, `reprezntacijaa_id`) VALUES ('3', '3', '2', '3', '4');
INSERT INTO `test`.`utakmica` (`id`, `broj_golovaa`, `broj_golovab`, `reprezentacijab_id`, `reprezntacijaa_id`) VALUES ('4', '1', '2', '4', '2');
