# Sometimes it's a README fix, or something like that - which isn't relevant for
# including in a project's CHANGELOG for example
declared_trivial = github.pr_title.include? "#trivial"

# Make it more obvious that a PR is a work in progress and shouldn't be merged yet
warn("PR is classed as Work in Progress") if github.pr_title.include? "[WIP]"

# If these are all empty something has gone wrong, better to raise it in a comment
if git.modified_files.empty? && git.added_files.empty? && git.deleted_files.empty?
  fail "This PR has no changes at all, this is likely an issue during development."
end

# Dont allow specific file to be deleted
if git.deleted_files.include? "*/AndroidManifest.xml"
	fail "You have deleted a file which you are not supposed to delete."
end

# If more then 10 files gets deleted.
warn("More then 10 files deleted file ") if git.deleted_files.length > 10

# Warn when there is a big PR
warn("Big PR") if git.lines_of_code > 500 

# Warn when there is a big PR
warn("Small PR") if git.lines_of_code < 500 
