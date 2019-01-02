require 'govuk_tech_docs'
require 'govuk_tech_docs/table_of_contents/heading'
require 'govuk_tech_docs/table_of_contents/headings_builder'

configure :build do
  base_path = ENV['BASE_PATH'] || '/' # Note: please ensure BASE_PATH ends with a trailing '/'

  activate :asset_host, host: base_path
  config[:http_prefix] = base_path

  module GovukTechDocs::TableOfContents::Helpers
    def render_page_tree(resources, current_page, config, current_page_html)
      resources = resources.sort_by { |r| [r.data.weight ? 0 : 1, r.data.weight || 0] }
      output = '';
      resources.each do |resource|
        content =
          if current_page.url == resource.url && current_page_html
            current_page_html
          else
            resource.render(layout: false)
          end
        # Avoid redirect pages
        next if content.include? "http-equiv=refresh"

        if resource.children.any? && resource.url != config[:http_prefix]
          output += %{<ul><li><a href="#{resource.url}">#{resource.data.title}</a>\n}
          output += render_page_tree(resource.children, current_page, config, current_page_html)
          output += '</li></ul>'
        else
          output +=
            single_page_table_of_contents(
              content,
              url: resource.url,
              max_level: config[:tech_docs][:max_toc_heading_level]
            )
        end
      end
      output
    end
  end

  module GovukTechDocs::TableOfContents
    class Heading
      def href
        @element_name == 'h1' ? @page_url : @page_url + '#' + @attributes['id']
      end
    end
  end
end

GovukTechDocs.configure(self)
