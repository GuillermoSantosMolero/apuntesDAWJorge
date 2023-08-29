<?php

declare(strict_types=1);

namespace DoctrineMigrations;

use Doctrine\DBAL\Schema\Schema;
use Doctrine\Migrations\AbstractMigration;

/**
 * Auto-generated Migration: Please modify to your needs!
 */
final class Version20200514073348 extends AbstractMigration
{
    public function getDescription() : string
    {
        return '';
    }

    public function up(Schema $schema) : void
    {
        // this up() migration is auto-generated, please modify it to your needs
        $this->abortIf($this->connection->getDatabasePlatform()->getName() !== 'mysql', 'Migration can only be executed safely on \'mysql\'.');

        $this->addSql('CREATE TABLE idioma (ididioma INT AUTO_INCREMENT NOT NULL, descripcion VARCHAR(100) NOT NULL, PRIMARY KEY(ididioma)) DEFAULT CHARACTER SET utf8mb4 COLLATE `utf8mb4_unicode_ci` ENGINE = InnoDB');
        $this->addSql('CREATE TABLE pais (idpais INT AUTO_INCREMENT NOT NULL, nombre VARCHAR(100) NOT NULL, PRIMARY KEY(idpais)) DEFAULT CHARACTER SET utf8mb4 COLLATE `utf8mb4_unicode_ci` ENGINE = InnoDB');
        $this->addSql('CREATE TABLE provincia (idprovincia INT AUTO_INCREMENT NOT NULL, pais INT DEFAULT NULL, nombre VARCHAR(100) NOT NULL, INDEX fk_provincia_pais (pais), PRIMARY KEY(idprovincia)) DEFAULT CHARACTER SET utf8mb4 COLLATE `utf8mb4_unicode_ci` ENGINE = InnoDB');
        $this->addSql('CREATE TABLE user_registro (idpais INT NOT NULL, password BLOB NOT NULL, PRIMARY KEY(idpais)) DEFAULT CHARACTER SET utf8mb4 COLLATE `utf8mb4_unicode_ci` ENGINE = InnoDB');
        $this->addSql('ALTER TABLE provincia ADD CONSTRAINT FK_D39AF2137E5D2EFF FOREIGN KEY (pais) REFERENCES pais (idpais)');
        $this->addSql('ALTER TABLE user ADD idioma INT DEFAULT NULL, ADD pais INT DEFAULT NULL, ADD provincia INT DEFAULT NULL, ADD nombre VARCHAR(50) NOT NULL, ADD apellidos VARCHAR(100) NOT NULL, ADD fechadenacimiento DATE NOT NULL, ADD sexo VARCHAR(20) NOT NULL, ADD telefono VARCHAR(10) NOT NULL, ADD datosadicionales VARCHAR(500) NOT NULL, ADD ciudad VARCHAR(100) NOT NULL, ADD direccion VARCHAR(300) NOT NULL, ADD codigopostal INT NOT NULL');
        $this->addSql('ALTER TABLE user ADD CONSTRAINT FK_8D93D6491DC85E0C FOREIGN KEY (idioma) REFERENCES idioma (ididioma)');
        $this->addSql('ALTER TABLE user ADD CONSTRAINT FK_8D93D6497E5D2EFF FOREIGN KEY (pais) REFERENCES pais (idpais)');
        $this->addSql('ALTER TABLE user ADD CONSTRAINT FK_8D93D649D39AF213 FOREIGN KEY (provincia) REFERENCES provincia (idprovincia)');
        $this->addSql('CREATE INDEX fk_user_pais ON user (pais)');
        $this->addSql('CREATE INDEX fk_user_provincia ON user (provincia)');
        $this->addSql('CREATE INDEX fk_user_idioma ON user (idioma)');
    }

    public function down(Schema $schema) : void
    {
        // this down() migration is auto-generated, please modify it to your needs
        $this->abortIf($this->connection->getDatabasePlatform()->getName() !== 'mysql', 'Migration can only be executed safely on \'mysql\'.');

        $this->addSql('ALTER TABLE user DROP FOREIGN KEY FK_8D93D6491DC85E0C');
        $this->addSql('ALTER TABLE provincia DROP FOREIGN KEY FK_D39AF2137E5D2EFF');
        $this->addSql('ALTER TABLE user DROP FOREIGN KEY FK_8D93D6497E5D2EFF');
        $this->addSql('ALTER TABLE user DROP FOREIGN KEY FK_8D93D649D39AF213');
        $this->addSql('DROP TABLE idioma');
        $this->addSql('DROP TABLE pais');
        $this->addSql('DROP TABLE provincia');
        $this->addSql('DROP TABLE user_registro');
        $this->addSql('DROP INDEX fk_user_pais ON user');
        $this->addSql('DROP INDEX fk_user_provincia ON user');
        $this->addSql('DROP INDEX fk_user_idioma ON user');
        $this->addSql('ALTER TABLE user DROP idioma, DROP pais, DROP provincia, DROP nombre, DROP apellidos, DROP fechadenacimiento, DROP sexo, DROP telefono, DROP datosadicionales, DROP ciudad, DROP direccion, DROP codigopostal');
    }
}
