package cat.itb.m78.exercices.p2.db

import app.cash.sqldelight.db.QueryResult
import app.cash.sqldelight.db.SqlCursor
import app.cash.sqldelight.db.SqlSchema
import app.cash.sqldelight.driver.jdbc.sqlite.JdbcSqliteDriver

/**
 * Creates DB or executes migrations in needed
 */
fun migrateIfNeeded(driver: JdbcSqliteDriver, schema: SqlSchema<QueryResult.Value<Unit>>) {
    val currentVer = readVersion(driver)
    val schemaVer = schema.version
    if (currentVer == 0L) {
        schema.create(driver)
        updateVersion(driver, schemaVer)
    } else {
        if (schemaVer > currentVer) {
            schema.migrate(driver, currentVer, schemaVer)
            updateVersion(driver, schemaVer)
        } else if(currentVer > schemaVer){
            throw UnsupportedOperationException("Database can't downgrade from $currentVer to $schemaVer")
        }
    }
}

private fun readVersion(driver: JdbcSqliteDriver): Long {
    val mapper = { cursor: SqlCursor ->
        QueryResult.Value(if (cursor.next().value) cursor.getLong(0) else null)
    }
    return driver.executeQuery(null, "PRAGMA user_version", mapper, 0, null).value ?: 0L
}

private fun updateVersion(driver: JdbcSqliteDriver, version: Long) {
    driver.execute(null, "PRAGMA user_version = $version", 0, null)
}